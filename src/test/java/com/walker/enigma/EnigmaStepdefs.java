package com.walker.enigma;

import junit.framework.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by walkercp on 23/04/2015.
 */
public class EnigmaStepdefs {

    private EnigmaMachine enigmaMachine;
    private String encodedMessage;

    @Given("^an Enigma machine with Reflector (.*), Rotors (.*),(.*),(.*)$")
    public void an_Enigma_machine_with_config(String reflector, String leftRotor, String midRotor, String rightRotor) throws Throwable {
        enigmaMachine = new EnigmaMachine(reflectorType(reflector), rotorType(leftRotor), rotorType(midRotor), rotorType(rightRotor));

    }

    private Reflector.ReflectorType reflectorType(String s){
        if (s.equals("B")){
            return Reflector.ReflectorType.REFLECTOR_B;
        }else if (s.equals("C")){
            return Reflector.ReflectorType.REFLECTOR_C;
        }
        return null;
    }

    private Rotor.RotorType rotorType(String s){
        if (s.equals("I")){
            return Rotor.RotorType.ROTORI;
        }else if (s.equals("II")){
            return Rotor.RotorType.ROTORII;
        }else if( s.equals("III")){
            return Rotor.RotorType.ROTORIII;
        }
        return null;
    }

    @And("^Groundsetting (.*)$")
    public void Groundsetting(String groundSetting) throws Throwable {
        System.out.println(groundSetting);
        enigmaMachine.setGroundSetting(groundSetting);
    }


    @When("^the input is \"([^\"]*)\"$")
    public void the_input_is(String input) throws Throwable {
        System.out.println(input);
        encodedMessage = enigmaMachine.encrypt(input);
    }

    @Then("^the output is \"([^\"]*)\"$")
    public void the_output_is(String expectedoOutput) throws Throwable {
        System.out.println(expectedoOutput);
        Assert.assertEquals(expectedoOutput, encodedMessage);
    }
}
