package com.mowitnow.kata.service;

import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.enumeration.Orientation;
import com.mowitnow.kata.factory.ServiceFactory;
import com.mowitnow.kata.services.RunService;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


public class RunServiceTest {
    private final RunService service = new ServiceFactory().buildServiceLunch();

    @Test
    @SneakyThrows
    public void runTest() {
        String FILE_PATH = "./src/test/resources/";
        List<MowerBean> results = service.run(new File(FILE_PATH +"test_ok.txt"));
        assertThat(results).hasSize(2);
        assertThat(results.get(0).getCoordinate().toString()).isEqualTo("1 3 N");
        assertThat(results.get(0).getCoordinate().getOrientation()).isEqualTo(Orientation.NORTH);
    }
}
