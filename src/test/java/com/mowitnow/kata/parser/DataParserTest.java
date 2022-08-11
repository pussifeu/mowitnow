package com.mowitnow.kata.parser;

import com.mowitnow.kata.factory.ParserFactory;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class DataParserTest {

    private final DataParser dataParser = new ParserFactory().buildDataParser();
    @Test
    public void checkPositionAndOrientation() {
        assertThat(dataParser.checkPositionAndOrientation("")).isFalse();
        assertThat(dataParser.checkPositionAndOrientation("1 2 3")).isFalse();
        assertThat(dataParser.checkPositionAndOrientation("1 2 N")).isTrue();
        assertThat(dataParser.checkPositionAndOrientation("1 2 S")).isTrue();
        assertThat(dataParser.checkPositionAndOrientation("12N")).isFalse();
    }

    @Test
    public void checkInstructions() {
        assertThat(dataParser.checkInstructions("")).isFalse();
        assertThat(dataParser.checkInstructions(" ")).isFalse();
        assertThat(dataParser.checkInstructions("D G")).isFalse();
        assertThat(dataParser.checkInstructions("DGN")).isFalse();
        assertThat(dataParser.checkInstructions("DGA")).isTrue();
        assertThat(dataParser.checkInstructions("GGAAAGADDA")).isTrue();
    }

    @Test
    public void checkLawnPosition() {
        assertThat(dataParser.checkLawnPosition("")).isFalse();
        assertThat(dataParser.checkLawnPosition("1 2 3")).isFalse();
        assertThat(dataParser.checkLawnPosition("123")).isFalse();
        assertThat(dataParser.checkLawnPosition("1 2 ")).isFalse();
        assertThat(dataParser.checkLawnPosition("1 2")).isTrue();
        assertThat(dataParser.checkLawnPosition("1 N")).isFalse();
    }
}
