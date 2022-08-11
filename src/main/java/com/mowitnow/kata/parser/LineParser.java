package com.mowitnow.kata.parser;

import com.mowitnow.kata.beans.CoordinateBean;
import com.mowitnow.kata.beans.LawnBean;
import com.mowitnow.kata.enumeration.Instruction;

import java.util.List;

public interface LineParser {
    CoordinateBean formatMowerLine(String mowerLine);
    LawnBean formatLawnLine(String lawnLine);
    List<Instruction> formatInstructionLine(String instructionLine);
}
