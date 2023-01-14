import utils.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// In this version we are playing with the BigInteger class to try and make the program
// work for larger integers. Unfortunately this will hamper the performance somewhat.

public class Qf79bBigInt {
    private static List<Pair<BigInteger,BigInteger>> cubesUpTo(BigInteger n) {
        ArrayList<Pair<BigInteger,BigInteger>> cubes = new ArrayList<>();
        for (var x = BigInteger.valueOf(0); x.compareTo(n) <= 0; x = x.add(BigInteger.valueOf(1))) {
            cubes.add(new Pair<>(x, x.multiply(x.multiply(x))));
        }
        return cubes;
    }

    private static boolean isPalindromeRecursive(String s) {
        if (s.length() <= 1) {
            return true;
        }
        else {
            return (s.charAt(0) == s.charAt(s.length() - 1) && isPalindromeRecursive(s.substring(1, s.length() - 1)));
        }
    }

    public static void main(String[] args) {
        for (Pair<BigInteger, BigInteger> cube : cubesUpTo(BigInteger.valueOf(1000000))) {
            if (isPalindromeRecursive(String.valueOf(cube.second())) ) { // isPalindrome(cube.second())) {
                System.out.println(cube.first() + " cubed is " + cube.second());
            }
        }
    }
}
