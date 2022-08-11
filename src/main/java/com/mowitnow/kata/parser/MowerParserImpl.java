package com.mowitnow.kata.parser;

import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.factory.ParserFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MowerParserImpl implements MowerParser {
    private DataParser dataParser;
    /**
     * @return true if mower information is correct, false otherwise
     */
    @Override
    public boolean checkParser(MowerParserBean bean) {
        this.dataParser = new ParserFactory().buildDataParser();
        return dataParser.checkPositionAndOrientation(bean.getCoordinate()) && dataParser.checkLawnPosition(bean.getLawn()) && dataParser.checkInstructions(bean.getInstructions());
    }
}