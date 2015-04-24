package com.walker.enigma;


public class Rotor
{

    private char[] rotorSubstitutions;
    private int currentPosition = 0;
    private int turnOverposition;
    private boolean turnOver = false;



    public enum RotorType{ROTORI,ROTORII,ROTORIII};

    public Rotor(RotorType type){
        switch(type){
            case ROTORI: rotorSubstitutions  = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N','T','O',
                                                          'W','Y','H','X','U','S','P','A','I','B','R','C','J'};
                         turnOverposition = 'R' - 'A';
                break;
            case ROTORII: rotorSubstitutions  = new char[]{'A','J','D','K','S','I','R','U','X','B','L','H','W',
                                                          'T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
                          turnOverposition = 'F' - 'A';
                break;
            case ROTORIII: rotorSubstitutions  = new char[]{'B','D','F','H','J','L','C','P','R','T','X','V','Z',
                                                            'N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
                          turnOverposition = 'W' - 'A';
                break;
        }
    }


    public char encrypt(char input){
        int inputOffset = input - 'A';
        return encrypt(inputOffset);
    }

    public char encrypt(int inputOffset){
        int inputPosition = -1;
        char output;
        inputPosition = currentPosition + inputOffset;
        if(inputPosition > -1) {
            output = rotorSubstitutions[inputPosition % 26];
            return output;
        }else{
            System.out.println("Invalid character for encryption: ");
            return '-';
        }
    }

    public int getOutputPosition(char encryptedChar){

        return ((encryptedChar - 'A') - currentPosition +26) % 26;
    }

    public int getOutputPositionForReverse(char encryptedChar){
        for(int i=0; i<rotorSubstitutions.length; i++){
            int position = (i + currentPosition) % 26;
            if (encryptedChar == rotorSubstitutions[position]){
                return i;
            }
        }
        System.out.println("ERROR in reverse direction");
        return -1;
    }

    public char encryptReverseDirection(int inputPosition) {
        int offSet = (inputPosition + currentPosition) % 26;

        return (char)((offSet+ 'A' ));
    }

    public void setRotorPosition(int position){
        currentPosition = position;
    }

    public void step(){
        currentPosition++;
        turnOver = currentPosition == turnOverposition;
    }

    public boolean doTurnOver(){
        if(turnOver){
            turnOver = false;
            return true;
        }
        return turnOver;
    }

    public static void main(String args[]){

        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        for (char letter:alphabet){
            System.out.println(letter + " = " + (letter-'A'));
        }
    }



}
