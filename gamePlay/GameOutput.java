package gamePlay;

public class GameOutput {


    protected void chooseGameDifficultyMessage() {
        System.out.println("Please, enter the secret code's length:");
    }

    protected void startTheGameMessage() {
        System.out.println("Okay, let's start a game!");
    }

    protected void playerTurnMessage(int turn) {
        System.out.printf("Turn %d:\n", turn);
    }


    protected void numberOfPossibleCharactersMessage() {
        System.out.println("Input the number of possible symbols in the code:");
    }

    protected void secretCodeIsReady(int codeLength, int possibleChars) {
        String code = "";
        for (int i = 0; i < codeLength; i++) {
            code += '*';
        }
        System.out.printf("The secret is prepared: %s (0-9, a-%c).\n", code,
                (char) ((possibleChars <= 10 ? 0 : possibleChars - 10 - 1) + 'a'));
    }

    protected void winningMessage() {
        System.out.printf("Congratulations! You guessed the secret code.\n");
    }

    // this message will be executed if the player didn't guess the correct digits at all
    protected void gradeMessage(int bulls, int cows) {

        System.out.println("Grade : " + (bulls <= 1 ? bulls + " bull " : bulls + " bulls ") +
                (cows <= 1 ? cows + " cow " : cows + " cows "));

    }
}
