package com.mowitnow.kata.parser;
import com.mowitnow.kata.beans.LawnBean;
import com.mowitnow.kata.enumeration.Instruction;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.factory.ParserFactory;
import com.mowitnow.kata.models.Position;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LineParserTest {

    private final LineParser lineParser = new ParserFactory().buildLineParser();
    @Test
    public void formatMowerLine() {
        assertThat(lineParser.formatMowerLine("10 15 N").getPosition()).isEqualTo(new Position(10, 15));
        assertThat(lineParser.formatMowerLine("10 15 N").getOrientation()).isEqualTo(Orientation.NORTH);
    }
    @Test
    public void formatLawnLine() {
        assertThat(lineParser.formatLawnLine("5 10")).isEqualTo(new LawnBean(new Position(5, 10)));
    }
    @Test
    public void formatInstructionLine() {
        assertThat(lineParser.formatInstructionLine("DGAD")).hasSize(4)
                .contains(Instruction.RIGHT)
                .contains(Instruction.LEFT)
                .contains(Instruction.FORWARD);
    }
}
