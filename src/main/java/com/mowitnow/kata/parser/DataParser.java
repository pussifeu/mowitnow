package com.mowitnow.kata.parser;


public interface DataParser {
    boolean checkPositionAndOrientation(String mower);
    boolean checkInstructions(String instructions);
    boolean checkLawnPosition(String lawn);
}
