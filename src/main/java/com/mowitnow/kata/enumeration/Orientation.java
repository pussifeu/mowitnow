package com.mowitnow.kata.enumeration;

public enum Orientation {
    NORTH('N'), EAST('E'), WEST('W'), SOUTH('S');
    private final char direction;

    Orientation(char direction) {
        this.direction = direction;
    }

    public char getOrientationCode() {
        return direction;
    }

    /**
     * get an Orientation enum corresponding to the given character
     *
     * @param codeOrientation: orientation character (E, W, N, S)
     * @return the enum corresponding to the given code orientation
     */
    public static Orientation getOrientation(char codeOrientation) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getOrientationCode() == codeOrientation) {
                return orientation;
            }
        }
        return null;
    }
}
