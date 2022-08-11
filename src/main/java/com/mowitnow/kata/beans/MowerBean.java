package com.mowitnow.kata.beans;


import com.mowitnow.kata.enumeration.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MowerBean {
    private LawnBean lawn;
    private CoordinateBean coordinate;
    private List<Instruction> instructions;
}
