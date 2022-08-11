package com.mowitnow.kata.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MowerParserBean {
    private String lawn;
    private String coordinate;
    private String instructions;
}
