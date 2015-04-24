package com.walker.enigma;

/**
 * Created by walkercp on 23/04/2015.
 */
public class EnigmaMachine {

    private Rotor[] rotors;
    private Reflector reflector;
    private static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public EnigmaMachine(Reflector.ReflectorType reflector, Rotor.RotorType leftRotor, Rotor.RotorType midRotor, Rotor.RotorType rightRotor){

        rotors = new Rotor[]{new Rotor(leftRotor), new Rotor(midRotor), new Rotor(rightRotor)};
        this.reflector = new Reflector(reflector);
    }

    public void setGroundSetting(String setting){
        if(setting.length() == rotors.length){
            char[] s = setting.toCharArray();
            for(int i=0; i < s.length; i++){
                rotors[i].setRotorPosition(s[i]-'A');
            }
        }else{
            System.out.println("This is wrong, probably throw an exception or something");
        }
    }

    public String encrypt(String input){
        char[] source = input.toCharArray();
        String output = "";
        for( char letter: source){
            output+= encryptLetter(letter);
        }
        return output;
    }

    private char encryptLetter(char letter){
        int inputPosition = letter - 'A';
        boolean turnOver = false;
        for(int i = rotors.length-1; i>-1; i--){

            if( i == rotors.length-1 || turnOver){
                rotors[i].step();
            }

            turnOver = rotors[i].doTurnOver();

            letter = rotors[i].encrypt(inputPosition);
            inputPosition = rotors[i].getOutputPosition(letter);
        }
        inputPosition = reflector.reflect(inputPosition);
        for(int i = 0; i<rotors.length; i++){
            letter = rotors[i].encryptReverseDirection(inputPosition);
            inputPosition = rotors[i].getOutputPositionForReverse(letter);
        }
        return alphabet[inputPosition];
    }

    public static void main (String args[]){
        int [] rotors = {1,2,3};
        for(int i = rotors.length-1; i>-1; i--){
            System.out.println(rotors[i]);
        }
    }

}
