package com.walker.enigma;

/**
 * Created by walkercp on 22/04/2015.
 */
public class Reflector {

    private int[] reflection;

    public enum ReflectorType{REFLECTOR_B,REFLECTOR_C};

    public Reflector(ReflectorType type){
        switch(type){
            case REFLECTOR_B: reflection = new int[] {24,17,20,7,16,18,11,3,15,23,13,6,14,10,12,8,4,1,5,25,2,22,21,9,0,19};
                break;
            case REFLECTOR_C: reflection = new int[] {5,21,15,9,8,0,14,24,4,3,17,25,23,22,6,2,19,10,20,16,18,1,13,12,7,11};
                break;
        }
    }



    public int reflect(int input){
        return reflection[input];
    }

}
