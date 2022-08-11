package com.mowitnow.kata.services;

import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.business.MowerBusiness;
import com.mowitnow.kata.exceptions.MowerMessage;
import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.factory.BusinessFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RunServiceImpl implements RunService {
    private final MowerBusiness mowerBusiness;

    public RunServiceImpl() {
        this.mowerBusiness = new BusinessFactory().buildMowerBusinessImpl();
    }

    /**
     *
     * @param file: given file that contains all instructions
     *  5 5
     * 1 2 N
     * GAGAGAGAA
     * 3 3 E
     * AADAADADDA
     * @return run with full instructions, coordinates and lawn limit position
     * @throws MowerException
     * @throws IOException
     */
    @Override
    public List<MowerBean> run(File file) throws MowerException, IOException {
        if (!file.isFile()) {
            throw new MowerException(MowerMessage.FILE_NOT_EXIST.getMessage());
        } else {
            MowerParserBean parser = new MowerParserBean();
            try (Scanner scanner = new Scanner(file)) {
                scanFirstLine(parser, scanner);
                return scanNextLines(parser, scanner);
            }
        }
    }

    /**
     * process the first line of the file
     *
     * @param parser
     * @param scanner
     * @throws MowerException: error if the file contains less than 2 lines
     */
    private void scanFirstLine(MowerParserBean parser, Scanner scanner) throws MowerException {
        if (scanner.hasNext()) {
            parser.setLawn(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new MowerException(MowerMessage.INCORRECT_DATA.getMessage());
        }
    }
    private List<MowerBean> scanNextLines(MowerParserBean parser, Scanner scanner) throws MowerException {
        List<MowerBean> positions = new ArrayList<>();
        while (scanner.hasNext()) {
            parser.setCoordinate(scanner.nextLine());
            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                positions.add(mowerBusiness.runMower(parser));
            } else {
                throw new MowerException(MowerMessage.INCORRECT_DATA.getMessage());
            }
        }
        return positions;
    }

}
