package com.walker.enigma;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Rotor.
 */
public class RotorTest
    extends TestCase
{

    private static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                                            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private static final int[] expectedOutputPositionsRotorIPosition0 = {4,10,12,5,11,6,3,16,21,25,13,19,14,22,24,7,23,20,18,15,0,8,1,17,2,9};

    private static final int[] expectedOutputPositionsRotorIPosition1 = {9,11,4,10,5,2,15,20,24,12,18,13,21,23,6,22,19,17,14,25,7,0,16,1,8,3};

    private static final int[] expectedOutputPositionsRotorIPosition25 = {10,5,11,13,6,12,7,4,17,22,0,14,20,15,23,25,8,24,21,19,16,1,9,2,18,3};

    private static final int[] expectedOutputPositionsRotorIIPosition0 = {0,9,3,10,18,8,17,20,23,1,11,7,22,19,12,2,16,6,25,13,15,24,5,21,14,4};

    private static final int[] expectedOutputPositionsRotorIIPosition1 = {8,2,9,17,7,16,19,22,0,10,6,21,18,11,1,15,5,24,12,14,23,4,20,13,3,25};

    private static final int[] expectedOutputPositionsRotorIIPosition25 = {5,1,10,4,11,19,9,18,21,24,2,12,8,23,20,13,3,17,7,0,14,16,25,6,22,15};

    private static final int[] expectedOutputPositionsRotorIIIPosition0 = {1,3,5,7,9,11,2,15,17,19,23,21,25,13,24,4,8,22,6,0,10,12,20,18,16,14};

    private static final int[] expectedOutputPositionsRotorIIIPosition1 = {2,4,6,8,10,1,14,16,18,22,20,24,12,23,3,7,21,5,25,9,11,19,17,15,13,0};

    private static final int[] expectedOutputPositionsRotorIIIPosition25 = {15,2,4,6,8,10,12,3,16,18,20,24,22,0,14,25,5,9,23,7,1,11,13,21,19,17};


    private void testRotorEncryption(Rotor r, int position, String expectedOutput, int[] expectedOutputPositions){
        int i = 0;
        String output = "";
        char encrypted;
        for (char letter:alphabet) {
            r.setRotorPosition(position);
            encrypted = r.encrypt(letter);
            output += encrypted;
            assertEquals(expectedOutputPositions[i], r.getOutputPosition(encrypted));
            i++;
        }
        assertEquals(output, expectedOutput);
    }

    public void testRotorIPosition0()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORI), 0, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", expectedOutputPositionsRotorIPosition0);
    }

    public void testRotorIPosition1()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORI),1, "KMFLGDQVZNTOWYHXUSPAIBRCJE", expectedOutputPositionsRotorIPosition1);
    }

    public void testRotorIPosition25()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORI),25, "JEKMFLGDQVZNTOWYHXUSPAIBRC", expectedOutputPositionsRotorIPosition25);
    }

    public void testRotorITurnOver()
    {
        Rotor r = new Rotor(Rotor.RotorType.ROTORI);
        r.setRotorPosition('R' - 'A');
        assertTrue(r.doTurnOver());
        r.setRotorPosition('Q' - 'A');
        assertFalse(r.doTurnOver());
    }


    public void testRotorIIPosition0()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORII), 0, "AJDKSIRUXBLHWTMCQGZNPYFVOE", expectedOutputPositionsRotorIIPosition0);
    }

    public void testRotorIIPosition1()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORII),1, "JDKSIRUXBLHWTMCQGZNPYFVOEA", expectedOutputPositionsRotorIIPosition1);
    }

    public void testRotorIIPosition25()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORII),25, "EAJDKSIRUXBLHWTMCQGZNPYFVO", expectedOutputPositionsRotorIIPosition25);
    }

    public void testRotorIITurnOver()
    {
        Rotor r = new Rotor(Rotor.RotorType.ROTORII);
        r.setRotorPosition('F' - 'A');
        assertTrue(r.doTurnOver());
        r.setRotorPosition('R' - 'A');
        assertFalse(r.doTurnOver());
    }
/*
    public void testRotorIITurnOverAlways()
    {
        Rotor r = new Rotor(Rotor.RotorType.ROTORII);
        r.setAlwaysTurn(true);
        r.setRotorPosition('F' - 'A');
        assertTrue(r.doTurnOver());
        r.setRotorPosition('R' - 'A');
        assertTrue(r.doTurnOver());
    }*/

    public void testRotorIIIPosition0()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORIII), 0, "BDFHJLCPRTXVZNYEIWGAKMUSQO", expectedOutputPositionsRotorIIIPosition0);
    }

    public void testRotorIIIPosition1()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORIII),1, "DFHJLCPRTXVZNYEIWGAKMUSQOB", expectedOutputPositionsRotorIIIPosition1);
    }

    public void testRotorIIIPosition25()
    {
        testRotorEncryption(new Rotor(Rotor.RotorType.ROTORIII),25, "OBDFHJLCPRTXVZNYEIWGAKMUSQ", expectedOutputPositionsRotorIIIPosition25);
    }

    public void testRotorIIIReverseDirection(){
        Rotor r = new Rotor(Rotor.RotorType.ROTORIII);
        r.setRotorPosition(0);
        char encrypted = r.encryptReverseDirection(7);
        assertEquals('H',encrypted);
        int outputPos = r.getOutputPositionForReverse(encrypted);
        assertEquals(3, outputPos);
    }

    public void testRotorIIIReverseDirectionPosition25(){
        Rotor r = new Rotor(Rotor.RotorType.ROTORIII);
        r.setRotorPosition(25);
        char encrypted = r.encryptReverseDirection(7);
        assertEquals('G',encrypted);
        int outputPos = r.getOutputPositionForReverse(encrypted);
        assertEquals(19, outputPos);
    }

    public void testRotorIIITurnOver()
    {
        Rotor r = new Rotor(Rotor.RotorType.ROTORIII);
        r.setRotorPosition('W' - 'A');
        assertTrue(r.doTurnOver());
        r.setRotorPosition('R' - 'A');
        assertFalse(r.doTurnOver());
    }
}
