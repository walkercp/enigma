Feature: Enigma encryption

  Scenario: An Enigma machine encryption with rotors (left to right) III,II,I in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors III,II,I
    And Groundsetting AAA
    When the input is "AA"
    Then the output is "FT"

  Scenario: An Enigma machine encryption with rotors (left to right) III,II,I in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors III,II,I
    And Groundsetting AAA
    When the input is "HELLOWORLD"
    Then the output is "MFNCZBBFZM"

  Scenario: An Enigma machine encryption with rotors (left to right) III,II,I in groundsetting AAA
    Given an Enigma machine with Reflector C, Rotors III,II,I
    And Groundsetting AAA
    When the input is "HELLOWORLD"
    Then the output is "WOXSYDRYII"

  Scenario: An Enigma machine decryption, with rotors (left to right) III,II,I in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors III,II,I
    And Groundsetting AAA
    When the input is "MFNCZBBFZM"
    Then the output is "HELLOWORLD"

  Scenario: An Enigma machine encryption with rotors (left to right) III,II,I in groundsetting AAQ
    Given an Enigma machine with Reflector B, Rotors III,II,I
    And Groundsetting AAQ
    When the input is "HELLOWORLD"
    Then the output is "QSPHZPUNRA"

  Scenario: An Enigma machine encryption with rotors (left to right) I,II,III in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors I,II,III
    And Groundsetting AAA
    When the input is "HELLOWORLD"
    Then the output is "ILBDAAMTAZ"

  Scenario: An Enigma machine encryption with rotors (left to right) I,II,III in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors I,II,III
    And Groundsetting QEV
    When the input is "HELLOWORLD"
    Then the output is "ZJQYJEBQIV"

  Scenario: An Enigma machine decryption with rotors (left to right) I,II,III in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors I,II,III
    And Groundsetting QEV
    When the input is "ZJQYJEBQIV"
    Then the output is "HELLOWORLD"

  Scenario: An Enigma machine encryption with rotors (left to right) II,I,III in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors II,I,III
    And Groundsetting EQV
    When the input is "HELLOWORLD"
    Then the output is "RWIWNUAJOH"

  Scenario: An Enigma machine decryption with rotors (left to right) II,I,III in groundsetting AAA
    Given an Enigma machine with Reflector B, Rotors II,I,III
    And Groundsetting EQV
    When the input is "RWIWNUAJOH"
    Then the output is "HELLOWORLD"