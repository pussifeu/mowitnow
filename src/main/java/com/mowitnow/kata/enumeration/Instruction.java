package com.mowitnow.kata.enumeration;

public enum Instruction {
    RIGHT('D'), LEFT('G'), FORWARD('A');
    private final char code;
    Instruction(char code) {
        this.code = code;
    }
    public char getCode() {
        return code;
    }
    /**
     * get an Instruction corresponding to the given character
     * @param codeInstruction : character instruction (A, G, D)
     * @return the enum corresponding to the given code instruction
     */
    public static Instruction getInstruction(char codeInstruction){
        for(Instruction instruction : Instruction.values()) {
            if (instruction.getCode() == codeInstruction) {
                return instruction;
            }
        }
        return null;
    }
}
