package Cac.Calculator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A collection of mathematical operations. Originally used for
 * a more oop approach on the Calc_Console_Interface class
 *
 * @author Dizzie
 * @version 4.0
 */
public class Calc {


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
        int b = decimalNumber;
        int d = 0;
        while (b > 0) {
            b = b / 2;
            d++;
        }
        long[] binaryArray = new long[d];
        String[] binaryStringArray = new String[d];
        for (int j = d - 1; j >= 0; j--) {
            binaryArray[j] = decimalNumber % 2;
            binaryStringArray[j] = binaryArray[j] + "";
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
        long n = 0;
        for (int i = 0; i < digitsOfBinaryNumber; i++) {
            binaryStringArray[i] = binaryNumberString.substring(i, i + 1);
        }
        for (int i = 0; i < digitsOfBinaryNumber; i++) {
            binaryNumberArray[i] = Integer.parseInt(binaryStringArray[i]);
        }
        int v2 = digitsOfBinaryNumber - 1;
        for (int i = 0; i < digitsOfBinaryNumber; i++) {
            n = n + Math.round(Math.pow(2, v2)) * binaryNumberArray[i];
            v2--;
        }
        return n;
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
        int v2 = binaryNumberDigits - 1;
        for (int i = 0; i < binaryNumberDigits; i++) {
            decimalReturnValue = decimalReturnValue + Math.round(Math.pow(2, v2)) * binaryNumberIntArray[i];
            v2--;
        }
        return decimalReturnValue;
    }

    /**
     * Checks if inputNumber is a prime number and if it is returns 'true' otherwise it will return 'false'.
     * @param inputNumber
     * @return 'true' if inputNumber is a prime number and 'false' if otherwise.
     */
    public static boolean isPrimeNumber( int inputNumber ) {
        int remainderOfFraction;
        for ( int i = 2 ; i < inputNumber ; i++ ) {
            remainderOfFraction = inputNumber % i;
            if ( remainderOfFraction == 0 ) return false;
        }
        return true;
    }

    /**
     * Checks if inputNumber is even and returns 'true' if it is and 'false' if otherwise.
     * @param inputNumber
     * @return returns wether inputNumber is even or odd.
     */
    public static boolean isEven(int inputNumber){
        int remainderOfFraction = inputNumber % 2;
        return remainderOfFraction == 0;
    }
    //TODO Find more methods for Calc class.
}

