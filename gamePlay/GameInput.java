package gamePlay;

import java.util.Scanner;

public class GameInput {

    final static Scanner input = new Scanner(System.in);

    // input : User guessed number.
    protected static String iGuess() {
        String guess = input.nextLine();
        return guess;
    }


    // input : difficulty of the game (number of digits of the secret code).
    protected static String length() {
        return input.nextLine();
    }

    // input : Range of possible characters in the secret code.
    protected static String rangeOfPossibleCharacters() {
        return input.nextLine();
    }

    // General usage input
    protected static int in() {
        return input.nextInt();
    }

}