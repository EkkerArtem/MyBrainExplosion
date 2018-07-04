package com.ekker.commands;

import com.ekker.InputData;

import java.io.InputStream;

/**
 * Created by Artem on 7/3/2018.
 */
class IncrementCurrentValue implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        inputData.getMemory()[inputData.getDataPointer()]++;
    }
}
