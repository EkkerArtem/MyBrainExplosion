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

public class IncrementCurrentValueTest {
    @Test
    public void doInterpret() throws Exception {
        InputData inputData = new InputData(55,"+++++++++++++++++++++++++++++++++");
        IncrementCurrentValue incrementCurrentValue = new IncrementCurrentValue();
        for(int i = inputData.getCode().length(); i>=0; i--) {
            incrementCurrentValue.doInterpret(inputData);
        }
        char source = (char) (inputData.getMemory()[inputData.getDataPointer()]);
        char expected = 34;
        assertEquals(expected,source);
    }

    @Test
    public void doInterpretOnce() throws Exception {
        InputData inputData = new InputData(55,"+++++++++++++++++++++++++++++++++");
        IncrementCurrentValue incrementCurrentValue = new IncrementCurrentValue();
        incrementCurrentValue.doInterpret(inputData);

        char source = (char) (inputData.getMemory()[inputData.getDataPointer()]);
        char expected = 1;
        assertEquals(expected,source);
    }
}
