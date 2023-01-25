import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Q014e {

  public static void main(String[] args) {
    // Setup
    final int x = Integer.parseInt(args[0]);
    final Random random = new Random();
    List<Integer> numbers = new ArrayList<>();
    Set<Integer> generated = new TreeSet<>();

    // Start producing the numbers
    System.out.println("Generating random numbers:");
    while (generated.size() < x) {
      final int newNumber = random.nextInt(x);
      generated.add(newNumber);
      numbers.add(newNumber);
    }

    // Output the numbers
    for (int i = 0; i < numbers.size() - 1; i++) {
      System.out.printf("%d, ", numbers.get(i));
    }
    System.out.println(numbers.get(numbers.size() - 1));

    // Conclude
    System.out.printf("I had to generate %d random numbers "
        + "between 0 and %d to have produced all "
        + "such numbers at least once.", numbers.size(), x);
  }

}
