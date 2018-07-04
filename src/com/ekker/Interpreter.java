package com.ekker;

import com.ekker.commands.BrainFuckCommandDispatcher;

/**
 * Created by Artem on 7/3/2018.
 */
public class Interpreter {

    private BrainFuckCommandDispatcher commandDispatcher;

    public Interpreter(BrainFuckCommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    public void interpret(String code) {
        InputData inputData = new InputData(65555, code);
        while (code.length() > inputData.getCurrentChar()) {
            commandDispatcher.getCommand(code.charAt(inputData.getCurrentChar())).doInterpret(inputData);
            inputData.setCurrentChar(inputData.getCurrentChar() + 1);
        }
    }
}
