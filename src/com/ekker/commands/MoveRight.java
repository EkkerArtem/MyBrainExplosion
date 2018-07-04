package com.ekker.commands;

import com.ekker.InputData;

/**
 * Created by Artem on 7/3/2018.
 */
class MoveRight implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        if (inputData.getDataPointer() == inputData.getLength() - 1) {
            inputData.setDataPointer(0);
        } else {
            inputData.setDataPointer(inputData.getDataPointer() + 1);
        }
    }

}
