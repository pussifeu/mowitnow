package com.mowitnow.kata.business;

import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.beans.MowerParserBean;
import com.mowitnow.kata.exceptions.MowerException;

public interface MowerBusiness {
    MowerBean runMower(MowerParserBean parser) throws MowerException;
}
