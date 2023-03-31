package Tools;

import java.util.concurrent.ThreadLocalRandom;
/**
 * A collection of mathematical operations. Originally used for
 * a more oop approach on the Calc_Console_Interface class
 *
 * @author Dizzie
 * @version 4.0
 */
public class NumberTools {

    /**
     * Rounds a double to a specified number of digits.
     * @param input double to be rounded.
     * @param digits digits after the decimal point to be displayed
     * @return input rounded to specified digits after the decimal point as a String, if the double has fewer digits than specified it will only return up to the last digit.
     */
    public static String roundToString(double input, int digits) {
        if ( input == Math.round(input) ) {
            return Math.round(input) + "";
        }
        char[] arrayOfCharsInGivenDouble = (input + "").toCharArray();
        boolean searchForDigitsAfterDecimalPoint = false;
        int digitsAfterDecimalPoint = 0;
        int digitsBeforeDecimalPoint = 0;
        int lastDigitAfterDecimalPoint = 0;
        for ( char forEachLoopCharArray : arrayOfCharsInGivenDouble ) {
            if ( searchForDigitsAfterDecimalPoint ) {
                ++digitsAfterDecimalPoint;
            } else {
                ++digitsBeforeDecimalPoint;
            }
            if ((forEachLoopCharArray + "").equals(".")) {
                searchForDigitsAfterDecimalPoint = true;
            }
        }

        String[] stringArrayOfDouble;
        if (digitsAfterDecimalPoint > digits) {
            stringArrayOfDouble = new String[digits + digitsBeforeDecimalPoint];
            for (int currentDigit = 0; currentDigit < digits + digitsBeforeDecimalPoint; currentDigit++) {
                stringArrayOfDouble[currentDigit] = arrayOfCharsInGivenDouble[currentDigit] + "";
            }
            lastDigitAfterDecimalPoint = Integer.parseInt(arrayOfCharsInGivenDouble[digits+digitsBeforeDecimalPoint]+"");
        } else {
            stringArrayOfDouble = new String[digitsAfterDecimalPoint + digitsBeforeDecimalPoint];
            for (int currentDigit = 0; currentDigit < digitsAfterDecimalPoint + digitsBeforeDecimalPoint; currentDigit++) {
                stringArrayOfDouble[currentDigit] = arrayOfCharsInGivenDouble[currentDigit] + "";
            }
        }
        int lengthOfStringArrayOfDouble = stringArrayOfDouble.length;
        while (stringArrayOfDouble[lengthOfStringArrayOfDouble - 1].equals("0")) {
            stringArrayOfDouble = new String[lengthOfStringArrayOfDouble - 1];
            lengthOfStringArrayOfDouble = stringArrayOfDouble.length;
            for (int currentDigit = 0; currentDigit < lengthOfStringArrayOfDouble; currentDigit++) {
                stringArrayOfDouble[currentDigit] = arrayOfCharsInGivenDouble[currentDigit] + "";
            }
        }
        if ( lastDigitAfterDecimalPoint > 5){
            stringArrayOfDouble[lengthOfStringArrayOfDouble-1] = (Integer.parseInt(arrayOfCharsInGivenDouble[lengthOfStringArrayOfDouble-1] + "")+1)+"";
        }
        String stringOfDoubleToBeReturned = "";
        for (String sa : stringArrayOfDouble) {
            stringOfDoubleToBeReturned += sa;
        }
        return stringOfDoubleToBeReturned;
    }

    /**
     * Rounds a double to a specified number of digits.
     * @param input double to be rounded.
     * @param digits digits after the decimal point to be displayed
     * @return input rounded to specified digits after the decimal point, if the double has fewer digits than specified it will only return up to the last digit.
     */
    public static double roundToDouble(double input, int digits) {
        if (input == Math.round(input)) {
            return Math.round(input);
        }
        char[] charArrayOfGivenDouble = (input + "").toCharArray();
        boolean searchForDigitsAfterDecimalPoint = false;
        int digitsAfterDecimalPoint = 0;
        int digitsBeforeDecimalPoint = 0;
        int lastDigitAfterDecimalPoint = 0;
        for (char forEachLoopCharArray : charArrayOfGivenDouble) {
            if (searchForDigitsAfterDecimalPoint) {
                ++digitsAfterDecimalPoint;
            } else {
                ++digitsBeforeDecimalPoint;
            }
            if ((forEachLoopCharArray + "").equals(".")) {
                searchForDigitsAfterDecimalPoint = true;
            }
        }

        String[] stringArrayOfDouble;
        if (digitsAfterDecimalPoint > digits) {
            stringArrayOfDouble = new String[digits + digitsBeforeDecimalPoint];
            for (int currentDigit = 0; currentDigit < digits + digitsBeforeDecimalPoint; currentDigit++) {
                stringArrayOfDouble[currentDigit] = charArrayOfGivenDouble[currentDigit] + "";
            }
            lastDigitAfterDecimalPoint = Integer.parseInt(charArrayOfGivenDouble[digits+digitsBeforeDecimalPoint]+"");
        } else {
            stringArrayOfDouble = new String[digitsAfterDecimalPoint + digitsBeforeDecimalPoint];
            for (int currentDigit = 0; currentDigit < digitsAfterDecimalPoint + digitsBeforeDecimalPoint; currentDigit++) {
                stringArrayOfDouble[currentDigit] = charArrayOfGivenDouble[currentDigit] + "";
            }
        }
        int lengthOfStringArrayOfDouble = stringArrayOfDouble.length;
        while (stringArrayOfDouble[lengthOfStringArrayOfDouble - 1].equals("0")) {
            stringArrayOfDouble = new String[lengthOfStringArrayOfDouble - 1];
            lengthOfStringArrayOfDouble = stringArrayOfDouble.length;
            for (int currentDigit = 0; currentDigit < lengthOfStringArrayOfDouble; currentDigit++) {
                    stringArrayOfDouble[currentDigit] = charArrayOfGivenDouble[currentDigit] + "";
            }
        }
        if ( lastDigitAfterDecimalPoint > 4){
                stringArrayOfDouble[lengthOfStringArrayOfDouble-1] = (Integer.parseInt(charArrayOfGivenDouble[lengthOfStringArrayOfDouble-1] + "")+1)+"";
            }

        String stringOfDouble = "";
        for (String sa : stringArrayOfDouble) {
            stringOfDouble += sa;
        }
        return Double.parseDouble(stringOfDouble);
    }

    /**
     * Generates random Number
     *
     * @param lowerBound lower bound
     * @param upperBound upper bound
     * @return pseudo-random number between lowerBound and upperBound
     */
    public static int rng(int lowerBound, int upperBound) {
        return ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
    }

    /**
     * Converts integers in the decimal system to the binary system
     *
     * @param decimalNumber integer in the decimal system
     * @return decimalNumber in the binary system
     */
    public static long Binary(int decimalNumber) {
        int decimalNumberCopy = decimalNumber;
        int digitsOfBinaryNumber = 0;
        while (decimalNumberCopy > 0) {
            decimalNumberCopy = decimalNumberCopy / 2;
            digitsOfBinaryNumber++;
        }
        long[] binaryArray = new long[digitsOfBinaryNumber];
        String[] binaryStringArray = new String[digitsOfBinaryNumber];
        for (int currentBinaryDigit = digitsOfBinaryNumber - 1; currentBinaryDigit >= 0; currentBinaryDigit--) {
            binaryArray[currentBinaryDigit] = decimalNumber % 2;
            binaryStringArray[currentBinaryDigit] = binaryArray[currentBinaryDigit] + "";
            decimalNumber = decimalNumber / 2;
        }
        String binaryString = String.join("", binaryStringArray);
        return Long.parseLong(binaryString);
    }

    /**
     * Converts binaryNumberString to a long integer in the decimal system
     *
     * @param binaryNumberString a number in the binary system as a string
     * @return binaryNumberString in the decimal system
     */
    public static long decimal(String binaryNumberString) {
        int digitsOfBinaryNumber = binaryNumberString.length();
        int[] binaryNumberArray = new int[digitsOfBinaryNumber];
        String[] binaryStringArray = new String[digitsOfBinaryNumber];
        long decimalNumber = 0;
        for (int currentDigit = 0; currentDigit < digitsOfBinaryNumber; currentDigit++) {
            binaryStringArray[currentDigit] = binaryNumberString.substring(currentDigit, currentDigit + 1);
        }
        for (int currentDigit = 0; currentDigit < digitsOfBinaryNumber; currentDigit++) {
            binaryNumberArray[currentDigit] = Integer.parseInt(binaryStringArray[currentDigit]);
        }
        int powerOfBinaryDigit = digitsOfBinaryNumber - 1;
        for (int currentDigit = 0; currentDigit < digitsOfBinaryNumber; currentDigit++) {
            decimalNumber = decimalNumber + Math.round(Math.pow(2, powerOfBinaryDigit)) * binaryNumberArray[currentDigit];
            powerOfBinaryDigit--;
        }
        return decimalNumber;
    }

    /**
     * Converts binaryNumber to a long integer in the decimal system
     *
     * @param binaryNumber a number in the binary system
     * @return binaryNumber in the decimal system
     */
    public static long decimal(int binaryNumber) {
        String number = Integer.toString(binaryNumber);
        int binaryNumberDigits = number.length();
        int[] binaryNumberIntArray = new int[binaryNumberDigits];
        String[] binaryNumberStringArray = new String[binaryNumberDigits];
        long decimalReturnValue = 0;
        for (int i = 0; i < binaryNumberDigits; i++) {
            binaryNumberStringArray[i] = number.substring(i, i + 1);
        }
        for (int i = 0; i < binaryNumberDigits; i++) {
            binaryNumberIntArray[i] = Integer.parseInt(binaryNumberStringArray[i]);
        }
        int powerOfBinaryDigit = binaryNumberDigits - 1;
        for (int currentDigit = 0; currentDigit < binaryNumberDigits; currentDigit++) {
            decimalReturnValue = decimalReturnValue + Math.round(Math.pow(2, powerOfBinaryDigit)) * binaryNumberIntArray[currentDigit];
            powerOfBinaryDigit--;
        }
        return decimalReturnValue;
    }

    /**
     * Checks if inputNumber is a prime number and if it is returns 'true' otherwise it will return 'false'.
     *
     * @param inputNumber
     * @return 'true' if inputNumber is a prime number and 'false' if otherwise.
     */
    public static boolean isPrimeNumber(int inputNumber) {
        int remainderOfFraction;
        for (int numberUpToInputNumber = 2; numberUpToInputNumber < inputNumber; numberUpToInputNumber++) {
            remainderOfFraction = inputNumber % numberUpToInputNumber;
            if (remainderOfFraction == 0) return false;
        }
        return true;
    }

    /**
     * Checks if inputNumber is even and returns 'true' if it is and 'false' if otherwise.
     *
     * @param inputNumber
     * @return returns whether inputNumber is even or odd.
     */
    public static boolean isEven(int inputNumber) {
        return inputNumber % 2 == 0;
    }

    /**
     * Returns the n-th number of the fibonacci-sequence.
     * @param n number of member of the fibonacci-sequence.
     * @return n-th member of the fibonacci-sequence.
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     *  Returns a double rounded to an int.
     * @param input double to be rounded.
     * @return input rounded to int.
     */
    public static int roundToInt(double input){
        char[] c = (input+"").toCharArray();
        int digitsBeforeDecimalPoint = 0;
        for (char ca:c) {
            ++digitsBeforeDecimalPoint;
            if ( (ca+"").equals(".") ){
                break;
            }
        }
        String w = "";
        for ( int i = 0 ; i < digitsBeforeDecimalPoint-1 ; i++){
            w += c[i]+"";
        }
        int r = Integer.parseInt(w);
        if ( Integer.parseInt(c[digitsBeforeDecimalPoint]+"")>4){
            r++;
        }
        return r;
    }
    //TODO find new methods
    //TODO make code more readable
}
