package com.walker.enigma;

import junit.framework.TestCase;

/**
 * Created by walkercp on 22/04/2015.
 */
public class ReflectorTest extends TestCase{

    private static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public void testReflectorB(){
        Reflector rB = new Reflector(Reflector.ReflectorType.REFLECTOR_B);
        int [] expectedOutput = {24,17,20,7,16,18,11,3,15,23,13,6,14,10,12,8,4,1,5,25,2,22,21,9,0,19};
        int i =0;
        for( char letter: alphabet){
            int input = letter -'A';
            int outputPosition = rB.reflect(input);
            assertEquals(expectedOutput[i], outputPosition);
            i++;
        }

    }

    public void testReflectorC(){
        Reflector rC = new Reflector(Reflector.ReflectorType.REFLECTOR_C);
        int [] expectedOutput = {5,21,15,9,8,0,14,24,4,3,17,25,23,22,6,2,19,10,20,16,18,1,13,12,7,11};
        int i =0;
        for( char letter: alphabet){
            int input = letter -'A';
            int outputPosition = rC.reflect(input);
            assertEquals(expectedOutput[i], outputPosition);
            i++;
        }
    }

}
