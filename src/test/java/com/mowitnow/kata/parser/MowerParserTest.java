package com.mowitnow.kata.parser;

import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.factory.ParserFactory;
import org.junit.Test;


import static org.fest.assertions.Assertions.assertThat;
public class MowerParserTest {

    private final MowerParser mowerParser  = new ParserFactory().buildMowerParser();
    @Test
    public void parseMowerAllDataCorrect(){
        MowerParserBean bean = new MowerParserBean();
        bean.setInstructions("DGDGA");
        bean.setLawn("50 5");
        bean.setCoordinate("1 2 N");
        assertThat(mowerParser.checkParser(bean)).isTrue();
    }
    @Test

    public void parseMowerLawnIncorrect(){
        MowerParserBean bean = new MowerParserBean();
        bean.setInstructions("DGDGA");
        bean.setLawn("0 -1");
        bean.setCoordinate("1 2 N");
        assertThat(mowerParser.checkParser(bean)).isFalse();
    }

    @Test
    public void parseMowerEmptyData(){
        MowerParserBean bean = new MowerParserBean();
        bean.setInstructions("");
        bean.setLawn("");
        bean.setCoordinate("");
        assertThat(mowerParser.checkParser(bean)).isFalse();
    }
}
