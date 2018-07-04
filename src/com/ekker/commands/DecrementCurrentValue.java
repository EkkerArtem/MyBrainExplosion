package com.ekker.commands;

import com.ekker.InputData;

/**
 * Created by Artem on 7/3/2018.
 */
class DecrementCurrentValue implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        inputData.getMemory()[inputData.getDataPointer()]--;
    }

}
