package gamePlay;

public class GameLogic {

    // store the number returned from GenerateRandomNumber() method
    private String randomNumber;

    private String randomChars;

    private String secretCode;

    private int bulls = 0;
    private int cows = 0;

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    // returns the random number so you can use it in  Output.java class
    protected String getRandomNumber() {
        return randomNumber;
    }

    // set the random number to the variable randomNumber
    protected void setRandomNumber(String random) {
        this.randomNumber = random;
    }

    public String getRandomChars() {
        return randomChars;
    }

    public void setRandomChars(String randomChars) {
        this.randomChars = randomChars;
    }


    // make random code by using a mixture of random numbers and random characters
    protected String mixRandomNumbersAndCharacters() {

        StringBuilder finalCode = new StringBuilder();

        java.util.Random rand = new java.util.Random();

        finalCode.append(this.randomNumber).append(this.randomChars);

        if (finalCode.length() < 2) {
            this.secretCode = finalCode.toString();
            return finalCode.toString();
        }

        /*
         *  Algorithm for mixing chars and numbers :
         *
         *  	# finalCode ex : 854102ab   :
         *   		(1) choose a random index from 0 to length - 1 and Swap the last with the index
         *   		(2) choose a random index from 0 to length - 1 and swap last - 1 with the index
         *   		(3) repeat in a loop for all the second half indexes
         *
         */
        for (int i = finalCode.length() - 1; i >= finalCode.length() / 2; i--) {

            int randomIndex = rand.nextInt((finalCode.length() - 1));
            // saving the character at the random index so it won't be lost while swapping
            char temp = finalCode.charAt(randomIndex);
            // replace the randomIndex with the last char
            finalCode.replace(randomIndex, randomIndex + 1, Character.toString(finalCode.charAt(i)));
            // replacing the last char with temp which is (char of the randomIndex)
            finalCode.replace(i, i + 1, Character.toString(temp));

        }

        this.secretCode = finalCode.toString();

        return finalCode.toString();
    }


    // checking the guessed number for how many bulls and cows
    protected void calculatingBullsAndCows(String guessedCode) {

        for (int i = 0; i < guessedCode.length(); i++) {
            for (int j = 0; j < secretCode.length(); j++) {
                if (guessedCode.charAt(i) == secretCode.charAt(j) && i == j) {
                    this.bulls++;
                    break;
                } else if (guessedCode.charAt(i) == secretCode.charAt(j) && i != j) {
                    this.cows++;
                    break;
                }

            }

        }

    }

    /* this method returns :
         (1) if the player guessed the exact number
         (0) if the player guessed some number(s)
         (-1) if the player number contains totally different digits
     */
    protected int grader(int length) {
        if (this.bulls == length && this.cows == 0) {
            return 1;
        } else if (this.bulls == 0 && this.cows == 0) {
            return -1;
        } else {
            return 0;
        }
    }

    // rest integers bulls and cows after using them in calculatingBullsAndCows() and grader() methods
    protected void resetBullsAndCows() {
        this.bulls = 0;
        this.cows  = 0;
    }

}
