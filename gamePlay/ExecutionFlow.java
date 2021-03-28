package gamePlay;

public class ExecutionFlow {

    GameLogic logic   	  		 = new GameLogic();
    GameInput input   	  		 = new GameInput();
    GameOutput output 	  		 = new GameOutput();
    RandomValue rand  	  	     = new RandomValue();
    HandlingInvalidInputs handle = new HandlingInvalidInputs();

    String difficulty = "";
    String rangeOfCharacters = "";

    protected void gameLoop() {

        output.chooseGameDifficultyMessage();
        // input : game difficulty (length of the secret code)
        difficulty = input.length();

        if (!handle.isValidNumber(difficulty)) {
            return;
        }

        if (!handle.validCodeLength(Integer.parseInt(difficulty))) {
            return;
        }

        output.numberOfPossibleCharactersMessage();
        rangeOfCharacters = input.rangeOfPossibleCharacters();

        if (!handle.isValidNumber(rangeOfCharacters)) {
            return;
        }

        if (!handle.inPossibleRange(Integer.parseInt(rangeOfCharacters))) {
            return;
        }

        if (handle.isSymbolsLengthLessThanSCode(Integer.parseInt(rangeOfCharacters), Integer.parseInt(difficulty))) {
            return;
        }

        int iDiff  = Integer.parseInt(difficulty);
        int iRange = Integer.parseInt(rangeOfCharacters);

        if (iDiff <= 36) {

            // generating the random number with the required difficulty
            String randomNumber  = rand.generateRandomNumber(iDiff);
            String randomChars = rand.generateRandomCharacters(iDiff, iRange);
            /*
             * set the random number returned from class generateRandomNumber in RandomNuber.java class
             * to randomNumber variable in GameLogic.java class
             */

            logic.setRandomNumber(randomNumber);
            logic.setRandomChars(randomChars);
            String secretCode = logic.mixRandomNumbersAndCharacters();
            output.secretCodeIsReady(secretCode.length(), iRange);

            // start the game Message
            output.startTheGameMessage();
            int turn = 1;
            int grade = 20;

            while (grade != 1) {

                output.playerTurnMessage(turn);
                // input : player2 guess
                String guessedCode = input.iGuess();

                if (!handle.isValidCode(guessedCode)) {
                    return;
                }

                // calculating bulls and cows based on the player2 guess (char[] guessedNumber)
                logic.calculatingBullsAndCows(guessedCode);
                // the method grader in GameLogic.java class returns :
                // (1) if the player guessed the exact number
                // (0) if the player guessed some number(s)
                // (-1) if the player number contains totally different digits
                if ((grade = logic.grader(iDiff)) == 1) {
                    output.gradeMessage(logic.getBulls(), logic.getCows());
                    output.winningMessage();
                } else if (grade == 0) {
                    output.gradeMessage(logic.getBulls(), logic.getCows());
                } else if (grade == -1) {
                    output.gradeMessage(logic.getBulls(), logic.getCows());
                }

                // values of cows and bulls integer should be reseted for a new turn (resetBullsAndCows() method)
                logic.resetBullsAndCows();

                turn++;
            }

        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", difficulty);
        }


    }

}