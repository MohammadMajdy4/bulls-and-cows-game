package gamePlay;

public class HandlingInvalidInputs {


    public boolean isSymbolsLengthLessThanSCode(int possibleSymboles, int length) {

        if (possibleSymboles < length) {
            System.out.printf("Error: it's not possible to generate a code with a "
                    + "length of %d with %d unique symbols.\n", length, possibleSymboles);
            return true;
        }

        return false;
    }



    public boolean isValidNumber(String inputNumber) {

        if (inputNumber.matches("\\d+")) {
            return true;
        } else {

            System.out.printf("Error: %s isn't a valid number.\n", inputNumber);
            return false;
        }

    }



    public boolean inPossibleRange(int range) {

        if (range <= 36 && range > 0) {
            return true;

        } else {

            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return false;
        }
    }




    public boolean validCodeLength(int length) {

        if (length > 0 && length <= 36) {
            return true;

        } else {

            System.out.println("Error: maximum length of the secret code is 36");
            return false;
        }
    }




    public boolean isValidCode(String code) {

        boolean valid = true;

        for (int i = 0; i < code.length(); i++) {

            if (code.charAt(i) >= '0' && code.charAt(i) <= '9' || code.charAt(i) >= 'a' && code.charAt(i) <= 'z') {
                // do nothing

            } else {

                valid = false;
                break;
            }
        }

        if (valid) {
            return valid;

        } else {

            System.out.println("Error : the answer contains invalid symbols!");
            return false;
        }
    }
}
