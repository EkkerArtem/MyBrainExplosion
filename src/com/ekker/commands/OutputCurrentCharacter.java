package com.ekker.commands;

import com.ekker.InputData;

/**
 * Created by Artem on 7/3/2018.
 */
class OutputCurrentCharacter implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        System.out.print((char) (inputData.getMemory()[inputData.getDataPointer()]));
    }

}
