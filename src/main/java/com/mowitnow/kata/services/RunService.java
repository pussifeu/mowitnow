package com.mowitnow.kata.services;

import com.mowitnow.kata.beans.MowerBean;
import com.mowitnow.kata.exceptions.MowerException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface RunService {
    List<MowerBean> run(File file) throws MowerException, IOException;
}
