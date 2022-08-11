package com.mowitnow.kata.Business;

import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.business.MowerBusiness;
import com.mowitnow.kata.factory.BusinessFactory;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MowerBusinessTest {
    private final MowerBusiness mowerBusiness = new BusinessFactory().buildMowerBusinessImpl();

    @SneakyThrows
    @Test
    public void runMower() {
        MowerParserBean parser1 = new MowerParserBean();
        parser1.setLawn("5 5");
        parser1.setCoordinate("1 2 N");
        parser1.setInstructions("GAGAGAGAA");

        MowerParserBean parser2 = new MowerParserBean();
        parser2.setLawn("5 5");
        parser2.setCoordinate("3 3 E");
        parser2.setInstructions("AADAADADDA");

        assertThat(mowerBusiness.runMower(parser1).getCoordinate().toString()).isEqualTo("1 3 N");
        assertThat(mowerBusiness.runMower(parser2).getCoordinate().toString()).isEqualTo("5 1 E");
    }
}
