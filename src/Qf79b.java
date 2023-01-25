import utils.Pair;

import java.util.ArrayList;
import java.util.List;

// The String method is as recommended in the Question and Answer
// The isPalindrome function could have been written recursively. (see below)
// It is probably better not to separate out the cubesUpTo logic, as the readability is not majorly improved by doing so,
//    and the performance is worse as a result.

public class Qf79b {
    private static List<Pair<Integer, Integer>> cubesUpTo(int n) {
        ArrayList<Pair<Integer, Integer>> cubes = new ArrayList<>();
        for (int x = 0; x <= n; ++x) {
            cubes.add(new Pair<>(x, x * x * x));
        }
        return cubes;
    }

    private static boolean isPalindrome(int n) {
        String digits = String.valueOf(n);
        for (int i = 0; i <= digits.length() / 2; i++) {
            if (digits.charAt(i) != digits.charAt(digits.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeRecursive(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            return (s.charAt(0) == s.charAt(s.length() - 1) && isPalindromeRecursive(s.substring(1, s.length() - 1)));
        }
    }

    public static void main(String[] args) {
        for (Pair<Integer, Integer> cube : cubesUpTo(1500)) {
            if (isPalindromeRecursive(String.valueOf(cube.second()))) { // isPalindrome(cube.second())) {
                System.out.printf("%d cubed is %d\n", cube.first(), cube.second());
            }
        }
    }
}

// The answer to the question is that the program will stop working with larger non-negative integers because we will
//    run into integer overflow. We could use Java BigInteger to solve this problem, but eventually we would still run
//    out of RAM.
