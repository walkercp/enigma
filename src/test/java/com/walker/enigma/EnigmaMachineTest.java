package com.walker.enigma;

import junit.framework.TestCase;

/**
 * Created by walkercp on 23/04/2015.
 */
public class EnigmaMachineTest extends TestCase{

    public void testEnigma1(){
        EnigmaMachine enigmaMachine = new EnigmaMachine(Reflector.ReflectorType.REFLECTOR_B, Rotor.RotorType.ROTORIII, Rotor.RotorType.ROTORII, Rotor.RotorType.ROTORI);
        enigmaMachine.setGroundSetting("AAA");
        String result = enigmaMachine.encrypt("AA");
        assertEquals("FT", result);
    }

    public void testEnigma2(){
        EnigmaMachine enigmaMachine = new EnigmaMachine(Reflector.ReflectorType.REFLECTOR_B, Rotor.RotorType.ROTORI, Rotor.RotorType.ROTORII, Rotor.RotorType.ROTORIII);
        enigmaMachine.setGroundSetting("AAA");
        String result = enigmaMachine.encrypt("HELLOWORLD");
        assertEquals("ILBDAAMTAZ", result);
    }

    public void testEnigma3(){
        EnigmaMachine enigmaMachine = new EnigmaMachine(Reflector.ReflectorType.REFLECTOR_B, Rotor.RotorType.ROTORI, Rotor.RotorType.ROTORII, Rotor.RotorType.ROTORIII);
        enigmaMachine.setGroundSetting("QEV");
        String result = enigmaMachine.encrypt("HELLOWORLD");
        assertEquals("ZJQYJEBQIV", result);
    }

}
