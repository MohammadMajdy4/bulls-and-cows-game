package gamePlay;

import java.util.Random;

public class RandomValue {

    Random rand = new Random();

    // this method Generates random Number and returns a long value
    public String generateRandomNumber(int length) {

        // New Random number Generator :
        length = length > 10 ? 10 : length <= 3 ? length : length - length / 3;
        StringBuilder pseudoRandomNumber = new StringBuilder();
        pseudoRandomNumber.append(rand.nextInt(((int) Math.pow(10, length) - 1)) +
                ((long) Math.pow(10, length - 1)));

        // Old Random number Generator :

       /*
        StringBuilder pseudoRandomNumber = new StringBuilder();
        String nanoTime;
        // reverse the long variable to get rid of tailing zeroes
        //so a number like 14025 % 1000 won't cause an error { 025 (we want 3 digit) -->> 25 (but we have only 2) }
        nanoTime = Long.toString(Long.reverse(System.nanoTime())).replace("0","1");
        // generating Random number with the required length, but it may have repeated numbers
        pseudoRandomNumber.append(Long.parseLong(nanoTime) % (long) Math.pow(10, length));
        */

        // appearance of digits in the random number
        int[] frequecy = new int[10];

        for (int i = 0; i < length; i++) {
            // if the frequency of a digit equals (1) then we have to change it with a digit with 0 frequency
            if (frequecy[(int) (pseudoRandomNumber.charAt(i) - '0')] == 1) {

                for (int j = 0; j <= 9; j++) {

                    if (frequecy[j] == 0) {
                        pseudoRandomNumber.replace(i, i + 1, Character.toString('0' + j));
                        frequecy[j]++;
                        break;
                    }
                }
            } else {
                // change frequency of the digit that appears for the first time from 0 to 1
                frequecy[(int) (pseudoRandomNumber.charAt(i) - '0')]++;
            }
        }
        if (pseudoRandomNumber.charAt(0) == '0') {
            pseudoRandomNumber.reverse();
        }

        return pseudoRandomNumber.toString();
    }




    public String generateRandomCharacters(int length, int possibleChars) {

        StringBuilder pseudoRandomChars = new StringBuilder();
        // deciding number of characters based on the length of code
        int numberOfChars = length > 10 ? length - 10 : length <= 3 ? 0 : length / 3;

        int[] frequency = new int[26];

        for (int i = 0; i < numberOfChars; i++) {

            boolean exist = false;

            while (!exist) {

                int randomChar = rand.nextInt(numberOfChars);

                if (frequency[randomChar] == 0) {

                    pseudoRandomChars.append((char) (randomChar + 'a'));
                    frequency[randomChar]++;
                    exist = true;

                }
            }
        }

        return pseudoRandomChars.toString();

    }


}