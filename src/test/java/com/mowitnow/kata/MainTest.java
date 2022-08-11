package com.mowitnow.kata;

import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.exceptions.MowerMessage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

public class MainTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private final String FILE_PATH = "./src/test/resources/";

    @Test
    public void testKO() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerMessage.INCORRECT_DATA.getMessage());
        Main.main(FILE_PATH + "test_ko.txt");
    }


    @Test
    public void testOK() throws MowerException, IOException {
        Main.main(FILE_PATH + "test_ok.txt");
        assertThat(Main.strResults).isNotNull();
        assertThat(Main.strResults).hasSize(2).contains("1 3 N").contains("5 1 E");
    }
}
