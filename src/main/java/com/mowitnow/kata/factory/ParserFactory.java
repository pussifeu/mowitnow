package com.mowitnow.kata.factory;

import com.mowitnow.kata.parser.*;

public class ParserFactory {
    public MowerParser buildMowerParser() {
        return new MowerParserImpl(new DataParserImpl());
    }
    public DataParser buildDataParser() {
        return new DataParserImpl();
    }
    public LineParser buildLineParser() {return new LineParserImpl();
    }
}
