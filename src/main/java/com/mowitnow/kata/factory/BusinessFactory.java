package com.mowitnow.kata.factory;

import com.mowitnow.kata.business.InstructionBusiness;
import com.mowitnow.kata.business.InstructionBusinessImpl;
import com.mowitnow.kata.business.MowerBusiness;
import com.mowitnow.kata.business.MowerBusinessImpl;

public class BusinessFactory {
    public InstructionBusiness buildInstructionBusinessImpl() {
        return new InstructionBusinessImpl();
    }
    public MowerBusiness buildMowerBusinessImpl() {
        return new MowerBusinessImpl();
    }

}
