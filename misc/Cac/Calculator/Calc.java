package Cac.Calculator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A collection of mathematical operations. Originally used for
 * a more oop approach on the Calc_Console_Interface class
 *
 * @author Dizzie
 * @version 3.0
 */
public class Calc {


    /**
     * Generates random Number
     *
     * @param x lower bound
     * @param y upper bound
     * @return random number between x and y
     */
    public static int rng(int x, int y) {
        return ThreadLocalRandom.current().nextInt(x, y + 1);
    }

    /**
     * Raises x to the power of y
     *
     * @param x base
     * @param y exponent
     * @return x to the y-th power
     */
    public static double exp(int x, int y) {
        return Math.pow(x, y);
    }

    /**
     * Converts integers in the decimal system to the binary system
     *
     * @param x integer in the decimal system
     * @return x in the binary system
     */
    public static long Binary(int x) {
        int b = x;
        int d = 0;
        while (b > 0) {
            b = b / 2;
            d++;
        }
        long[] binaryArray = new long[d];
        String[] binaryStringArray = new String[d];
        for (int j = d - 1; j >= 0; j--) {
            binaryArray[j] = x % 2;
            binaryStringArray[j] = binaryArray[j] + "";
            x = x / 2;
        }
        String binaryString = String.join("", binaryStringArray);
        return Long.parseLong(binaryString);
    }

    /**
     * Converts s in the binary system to a long integer in the decimal system
     *
     * @param s a number in the binary system as a string
     * @return s in the decimal system
     */
    public static long decimal(String s) {
        int v = s.length();
        int[] bin = new int[v];
        String[] nums = new String[v];
        long n = 0;
        for (int i = 0; i < v; i++) {
            nums[i] = s.substring(i, i + 1);
        }
        for (int i = 0; i < v; i++) {
            bin[i] = Integer.parseInt(nums[i]);
        }
        int v2 = v - 1;
        for (int i = 0; i < v; i++) {
            n = n + Math.round(Math.pow(2, v2)) * bin[i];
            v2--;
        }
        return n;
    }

    /**
     * Converts x in the binary system to a long integer in the decimal system
     *
     * @param x a number in the binary system
     * @return x in the decimal system
     */
    public static long decimal(int x) {
        String number = Integer.toString(x);
        int v = number.length();
        int[] bin = new int[v];
        String[] nums = new String[v];
        long n = 0;
        for (int i = 0; i < v; i++) {
            nums[i] = number.substring(i, i + 1);
        }
        for (int i = 0; i < v; i++) {
            bin[i] = Integer.parseInt(nums[i]);
        }
        int v2 = v - 1;
        for (int i = 0; i < v; i++) {
            n = n + Math.round(Math.pow(2, v2)) * bin[i];
            v2--;
        }
        return n;
    }

    
    public static boolean isPrimeNumber( int n ) {
        int b;
        for ( int i = 2 ; i < n ; i++ ) {
            b = n % i;
            if ( b == 0 ) return false;
        }
        return true;
    }
    
    public static boolean isEven(int n){
        int e = n % 2;
        return e == 0;
    }
}

