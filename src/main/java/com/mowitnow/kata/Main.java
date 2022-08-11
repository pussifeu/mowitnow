package com.mowitnow.kata;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.factory.ServiceFactory;
import com.mowitnow.kata.exceptions.MowerException;
import com.mowitnow.kata.services.RunService;


public class Main {

    protected static List<String> strResults;
    public static void main(String... args) throws MowerException, IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            RunService service = new ServiceFactory().buildServiceLunch();
            List<MowerBean> results = service.run(file);
            strResults = results.stream().map(mowerBean -> mowerBean.getCoordinate().toString()).collect(Collectors.toList());
            results.forEach(mowerBean -> System.out.println(mowerBean.getCoordinate()));
        } else {
            throw new IllegalArgumentException();
        }
    }

}