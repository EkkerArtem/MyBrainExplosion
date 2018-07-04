package com.ekker.commands;

import com.ekker.InputData;

/**
 * Created by Artem on 7/3/2018.
 */
class MoveLeft implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        if (inputData.getDataPointer() == 0) {
            inputData.setDataPointer(inputData.getLength() - 1);
        } else {
            inputData.setDataPointer(inputData.getDataPointer() - 1);
        }
    }
}
