package com.mowitnow.kata.business;

import com.mowitnow.kata.beans.CoordinateBean;
import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.models.Position;

public interface InstructionBusiness {
    Position forward(CoordinateBean bean, Position limitPosition) throws MowerException;

    Orientation right(Orientation orientation) throws MowerException;
    Orientation left(Orientation orientation) throws MowerException;
    void executeInstruction(CoordinateBean bean, Instruction instruction, Position limitPosition) throws MowerException;
}
