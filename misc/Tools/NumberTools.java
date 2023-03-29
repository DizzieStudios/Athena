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
    public static String roundToString(double input, int digits) {
        if (input == Math.round(input)) {
            return Math.round(input) + "";
        }
        char[] c = (input + "").toCharArray();
        boolean search = false;
        int n = 0;
        int b = 0;
        for (char ca : c) {
            if (search) {
                ++n;
            } else {
                ++b;
            }
            if ((ca + "").equals(".")) {
                search = true;
            }
        }

        String[] s;
        if (n > digits) {
            s = new String[digits + b];
            for (int i = 0; i < digits + b; i++) {
                s[i] = c[i] + "";
            }
        } else {
            s = new String[n + b];
            for (int i = 0; i < n + b; i++) {
                s[i] = c[i] + "";
            }
        }
        int l = s.length;
        while (s[l - 1].equals("0")) {
            s = new String[l - 1];
            l = s.length;
            for (int i = 0; i < l; i++) {
                s[i] = c[i] + "";
            }
        }
        String r = "";
        for (String sa : s) {
            r += sa;
        }
        return r;
    }

    public static double roundToDouble(double input, int digits) {
        if (input == Math.round(input)) {
            return Math.round(input);
        }
        char[] c = (input + "").toCharArray();
        boolean search = false;
        int n = 0;
        int b = 0;
        for (char ca : c) {
            if (search) {
                ++n;
            } else {
                ++b;
            }
            if ((ca + "").equals(".")) {
                search = true;
            }
        }

        String[] s;
        if (n > digits) {
            s = new String[digits + b];
            for (int i = 0; i < digits + b; i++) {
                s[i] = c[i] + "";
            }
        } else {
            s = new String[n + b];
            for (int i = 0; i < n + b; i++) {
                s[i] = c[i] + "";
            }
        }
        int l = s.length;
        while (s[l - 1].equals("0")) {
            s = new String[l - 1];
            l = s.length;
            for (int i = 0; i < l; i++) {
                s[i] = c[i] + "";
            }
        }
        String r = "";
        for (String sa : s) {
            r += sa;
        }
        return Double.parseDouble(r);
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
     *
     * @param inputNumber
     * @return 'true' if inputNumber is a prime number and 'false' if otherwise.
     */
    public static boolean isPrimeNumber(int inputNumber) {
        int remainderOfFraction;
        for (int i = 2; i < inputNumber; i++) {
            remainderOfFraction = inputNumber % i;
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
        int remainderOfFraction = inputNumber % 2;
        return remainderOfFraction == 0;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static int roundToInt(double input){
        char[] c = (input+"").toCharArray();
        int n = 0;
        for (char ca:c) {
            ++n;
            if ( (ca+"").equals(".") ){
                break;
            }
        }
        String w = "";
        for ( int i = 0 ; i < n-1 ; i++){
            w += c[i]+"";
        }
        int r = Integer.parseInt(w);
        if ( Integer.parseInt(c[n]+"")>4){
            r++;
        }
        return r;
    }
    //TODO find new methods
}
