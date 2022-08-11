package com.mowitnow.kata.factory;
import com.mowitnow.kata.services.RunService;
import com.mowitnow.kata.services.RunServiceImpl;

public class ServiceFactory {
    public RunService buildServiceLunch() {
        return new RunServiceImpl();
    }
}
