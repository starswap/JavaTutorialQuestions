import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Qf79b {
    public static List<Pair<Integer,Integer>> cubesUpTo(int n) {
        ArrayList<Pair<Integer,Integer>> cubes = new ArrayList<>();
        for (int x=0; x <= n; ++x) {
            cubes.add(new Pair<>(x, x*x*x));
        }
        return cubes;
    }

    public static boolean isPalindrome(int n) {
        String digits = String.valueOf(n);
        for (int i = 0; i <= digits.length() / 2; i++) {
            if (digits.charAt(i) != digits.charAt(digits.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (Pair<Integer, Integer> cube : cubesUpTo(1500)) {
            if (isPalindrome(cube.second())) {
                System.out.printf("%d cubed is %d\n",cube.first(), cube.second());
            }
        }
    }
}

// The answer to the question is that the program will stop working with larger non-negative integers because we will
//    run into integer overflow. We could use Java BigInteger to solve this problem, but eventually we would still run
//    out of RAM.
