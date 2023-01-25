import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q4c70 {
  public static final int numBalls = 7;
  public static final int maxNum = 49;

  public static void main(String[] args){
    System.out.println("Using random integer method:");
    printNumbers(getNumbers1());
    System.out.println("");
    System.out.println("Using shuffle method:");
    printNumbers(getNumbers2());
  }

  private static List<Integer> getNumbers1() {
    Random random = new Random();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < numBalls; ++i) {
      int newNumber = random.nextInt(maxNum - 1) + 1; // returns an integer from 0 to n.
      while (numbers.contains(newNumber)) {
        newNumber = random.nextInt(maxNum - 1) + 1; // returns an integer from 0 to n.
      }
      numbers.add(newNumber);
    }
    return numbers;
  }

  private static List<Integer> getNumbers2() {
    Random random = new Random();
    List<Integer> numbers = Stream.iterate(1, item -> item + 1).limit(maxNum).collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.stream().limit(numBalls).toList();
  }

  private static void printNumbers(List<Integer> numbers) {
    for (int i = 0; i < numBalls - 1; ++i) {
      System.out.printf("Number %d: %d\n", i + 1, numbers.get(i));
    }
    System.out.println("Bonus number: " + numbers.get(numBalls - 1));
  }

}
