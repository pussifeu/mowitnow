package com.mowitnow.kata.parser;

import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;

public class DataParserImpl implements DataParser {
    /**
     * check the position of the mower and its orientation
     * Position and orientation are provided as 2 numbers and a letter,
     * separated by a space
     *
     * @param mower
     * @return true if the orientations line is correct, false otherwise
     */
    @Override
    public boolean checkPositionAndOrientation(String mower) {
        String orientation = "" + Orientation.NORTH.getOrientationCode() + "|" + Orientation.SOUTH.getOrientationCode() + "|" + Orientation.EAST.getOrientationCode() + "|" + Orientation.WEST.getOrientationCode();
        return mower.matches("(\\d+) (\\d+) (" + orientation + ")");
    }

    /**
     * check line instructions
     * the instructions are a sequence of characters (G, D, A) without spaces
     *
     * @param instructions
     * @return true if the line of instructions is correct, false otherwise
     */
    @Override
    public boolean checkInstructions(String instructions) {
        String stringBuilder = "" + Instruction.FORWARD.getCode() + "|" + Instruction.RIGHT.getCode() + "|" + Instruction.LEFT.getCode();
        return instructions.matches("(" + stringBuilder + ")+");
    }

    /**
     * check the position of the lawn position is as 2 digits separated by space
     *
     * @param lawn
     * @return true if the line of instructions is correct, false otherwise
     */
    @Override
    public boolean checkLawnPosition(String lawn) {
        return lawn.matches("(\\d+) (\\d+)");
    }
}