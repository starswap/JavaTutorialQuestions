import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q4c70 {
  public static final int numBalls = 7; // Should make these constants private; nobody is going to need them outside this class.
  public static final int maxNum = 49;

  public static void main(String[] args){
    System.out.println("Using random integer method:");
    printNumbers(getNumbers1());
    System.out.println("");
    System.out.println("Using shuffle method:");
    printNumbers(getNumbers2());
  }

  // Ally represents his lottery numbers in an array. This could be more performant as we have a primitive
  //    type rather than ArrayList which is an object, however it means he has to define his own contains()
  //    loop.

  // To create a new integer array of a specified size:
  // int[] numbers = new int[numNumbers];
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
    List<Integer> numbers = Stream.iterate(1, item -> item + 1).limit(maxNum).collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.stream().limit(numBalls).toList();
  }

  // Similar to in a previous question, we could put it all together into one single
  //   loop with the generation and output logic together.
  private static void printNumbers(List<Integer> numbers) {
    for (int i = 0; i < numBalls - 1; ++i) {
      System.out.printf("Number %d: %d\n", i + 1, numbers.get(i));
    }
    System.out.println("Bonus number: " + numbers.get(numBalls - 1));
  }

}

// From reading the answer I have also learnt about named continue, whereby we put
//    a name above a loop and write continue name; so we jump there.
// Some testing reveals that this labelled jumping is not a full goto - rather it only
//   works above loops.
// This is not recommended simply because continue is not a good idea usually. It's
//   usually not required.
// From this question I have learnt:
//    - Collections.shuffle()
//    - named continue
//    - java.util.Random, random.nextInt()
//    - how to create a new array.
//    - constants might need to be private.
