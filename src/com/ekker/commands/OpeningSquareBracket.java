package com.ekker.commands;

import com.ekker.InputData;

/**
 * Created by Artem on 7/3/2018.
 */
class OpeningSquareBracket implements BrainFuckCommand {

    @Override
    public void doInterpret(InputData inputData) {
        int countOfBrackets = 0;

        if (inputData.getMemory()[inputData.getDataPointer()] == 0) {
            inputData.setCurrentChar(inputData.getCurrentChar() + 1);
            while (countOfBrackets > 0 || inputData.getCode().charAt(inputData.getCurrentChar()) != BrainFuckCommandDispatcher.CLOSING_BRACKET) {
                if (inputData.getCode().charAt(inputData.getCurrentChar()) == BrainFuckCommandDispatcher.OPENING_BRACKET)
                    countOfBrackets++;
                else if (inputData.getCode().charAt(inputData.getCurrentChar()) == BrainFuckCommandDispatcher.CLOSING_BRACKET)
                    countOfBrackets--;
                inputData.setCurrentChar(inputData.getCurrentChar() + 1);
            }
        }
    }

}
