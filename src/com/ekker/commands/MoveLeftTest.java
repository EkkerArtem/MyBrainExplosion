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

public class MoveLeftTest {
    @Test
    public void doInterpretInMinusValues() throws Exception {
        InputData inputData = new InputData(55,"<<<<<<<<<<<<<<<");
        MoveLeft moveLeft = new MoveLeft();
        for(int i = inputData.getCode().length(); i>=1; i--) {
            moveLeft.doInterpret(inputData);
        }
        int source = inputData.getDataPointer();
        int expected = 40;
        assertEquals(expected,source);
    }

    @Test
    public void doInterpretOnceInMinusValue() throws Exception {

        InputData inputData = new InputData(50,"<<<");
        MoveLeft moveLeft = new MoveLeft();
        moveLeft.doInterpret(inputData);
        int source = inputData.getDataPointer();
        int expected = 49;
        assertEquals(expected,source);
    }
}


