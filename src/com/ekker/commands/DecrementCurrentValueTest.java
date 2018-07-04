package com.ekker.commands;

import com.ekker.InputData;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Artem on 7/4/2018.
 */

public class DecrementCurrentValueTest {
    @Test
    public void doInterpret() throws Exception {
        InputData inputData = new InputData(65535, "----------");
        DecrementCurrentValue decrementCurrentValue = new DecrementCurrentValue();
        for (int i = inputData.getCode().length(); i >= 0; i--) {
            decrementCurrentValue.doInterpret(inputData);
        }
        char source = (char) ((inputData.getMemory()[inputData.getDataPointer()]) + 100);
        char expected = 'Z';
        assertEquals(expected, source);
    }

    @Test
    public void doInterpretOnce() throws Exception {
        InputData inputData = new InputData(65555, "-");
        DecrementCurrentValue decrementCurrentValue = new DecrementCurrentValue();
        decrementCurrentValue.doInterpret(inputData);

        char source = (char) ((inputData.getMemory()[inputData.getDataPointer()]) + 10);
        char expected = 9;
        assertEquals(expected, source);
    }

    @Test
    public void doInterpretBorderCheckNull() throws Exception {
        InputData inputData = new InputData(65535, "");
        DecrementCurrentValue decrementCurrentValue = new DecrementCurrentValue();
        for (int i = inputData.getCode().length(); i >= 0; i--) {
            decrementCurrentValue.doInterpret(inputData);
        }
        char source = (char) (inputData.getMemory()[inputData.getDataPointer()]);
        char expected = 0;
        assertEquals(expected, source);
    }

    @Test
    public void doInterpretBorderCheckAfterNull() throws Exception {
        InputData inputData = new InputData(65535, "-----");
        DecrementCurrentValue decrementCurrentValue = new DecrementCurrentValue();
        for (int i = inputData.getCode().length(); i >= 0; i--) {
            decrementCurrentValue.doInterpret(inputData);
        }
        char source = (char) (inputData.getMemory()[inputData.getDataPointer()]);
        char expected = 65530;
        assertEquals(expected, source);
    }
}