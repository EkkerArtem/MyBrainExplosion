package com.ekker.commands;

import com.ekker.InputData;
import com.ekker.Interpreter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Artem on 7/4/2018.
 */

public class MoveRightTest {

    @Test
    public void doInterpret() throws Exception {

        InputData inputData = new InputData(65555,">>>>>>>>>>");
        MoveRight moveRight = new MoveRight();
        for(int i = inputData.getCode().length(); i>=1; i--) {
            moveRight.doInterpret(inputData);
        }
        int source = inputData.getDataPointer();
        int expected = 10;
        assertEquals(expected,source);
    }

    @Test
    public void doInterpretBorderCheck() throws Exception {

        InputData inputData = new InputData(8,">>>>>>>>>>");
        MoveRight moveRight = new MoveRight();
        for(int i = inputData.getCode().length(); i>=1; i--) {
            moveRight.doInterpret(inputData);
        }
        int source = inputData.getDataPointer();
        int expected = 2;
        assertEquals(expected,source);
    }

    @Test
    public void doInterpretOnce() throws Exception {
        Interpreter interpreter = new Interpreter(new BrainFuckCommandDispatcher());
        InputData inputData = new InputData(65555,">>>>>>>>>>");
        MoveRight moveRight = new MoveRight();
        moveRight.doInterpret(inputData);
        int source = inputData.getDataPointer();
        int expected = 1;
        assertEquals(expected,source);
    }
}
