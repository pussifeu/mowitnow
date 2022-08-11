package com.mowitnow.kata.parser;

import com.mowitnow.kata.beans.CoordinateBean;
import com.mowitnow.kata.beans.LawnBean;
import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.models.Position;

import java.util.ArrayList;
import java.util.List;

public class LineParserImpl implements LineParser {
    private static final String SPACE = " ";

    /**
     * retrieve the position of the mower which is defined by its coordinates and its orientation
     *
     * @param mowerLine: mower position line (ex: 2 3 G)
     * @return the object that defines the position of the mower
     */
    @Override
    public CoordinateBean formatMowerLine(String mowerLine) {
        String[] elt = mowerLine.split(SPACE);
        Position coordinate = new Position(Integer.parseInt(elt[0]), Integer.parseInt(elt[1]));
        Orientation orientation = Orientation.getOrientation(elt[2].charAt(0));
        return new CoordinateBean(coordinate, orientation);
    }

    /**
     * retrieve the Lawn object containing the limit coordinates of the lawn
     *
     * @param lawnLine: line of the lawn (ex: 2 3)
     * @return the object that defines the boundary of the lawn
     */
    @Override
    public LawnBean formatLawnLine(String lawnLine) {
        String[] elt = lawnLine.split(SPACE);
        return new LawnBean(new Position(Integer.parseInt(elt[0]), Integer.parseInt(elt[1])));
    }

    /**
     * retrieve a list of instructions corresponding to the instruction line
     *
     * @param instructionLine: instruction sequence (ex: GDAGD)
     * @return a list of MowerInstrction enums
     */
    @Override
    public List<Instruction> formatInstructionLine(String instructionLine) {
        List<Instruction> listInstruction = new ArrayList<>();
        for (char instruction : instructionLine.toCharArray()) {
            listInstruction.add(Instruction.getInstruction(instruction));
        }
        return listInstruction;
    }
}