package com.mowitnow.kata.business;

import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.exceptions.MowerMessage;
import com.mowitnow.kata.factory.BusinessFactory;
import com.mowitnow.kata.factory.ParserFactory;
import com.mowitnow.kata.parser.LineParser;
import com.mowitnow.kata.parser.MowerParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MowerBusinessImpl implements MowerBusiness {
    private InstructionBusiness instructionBusiness;
    private MowerParser mowerParser;
    private LineParser lineParser;

    public MowerBusinessImpl() {
        this.instructionBusiness = new BusinessFactory().buildInstructionBusinessImpl();
        this.mowerParser = new ParserFactory().buildMowerParser();
        this.lineParser = new ParserFactory().buildLineParser();
    }

    /**
     * Run mower
     * @param parser
     * @return information of mower, it contains new coordinate, limit position information and instructions
     * @throws MowerException
     */
    @Override
    public MowerBean runMower(MowerParserBean parser) throws MowerException {
        if (!mowerParser.checkParser(parser)) {
            throw new MowerException(MowerMessage.INCORRECT_DATA.getMessage());
        } else {
            MowerBean bean = new MowerBean();
            bean.setLawn(lineParser.formatLawnLine(parser.getLawn()));
            bean.setCoordinate(lineParser.formatMowerLine(parser.getCoordinate()));
            bean.setInstructions(lineParser.formatInstructionLine(parser.getInstructions()));
            for (Instruction instruction : bean.getInstructions()) {
                instructionBusiness.executeInstruction(bean.getCoordinate(), instruction, bean.getLawn().getLimitPosition());
            }
            return bean;
        }
    }
}