import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2d33 {

  public static void main(String[] args) throws IOException {
   // System.out.println("About to start version 1:");
   // version1();
    System.out.println("About to start version 2:");
    version2();
  }

  // Assumes that we don't have more than 100 strings to store.
  private static void version1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // from an input stream we make an input stream reader, and then we make a buffered reader from that.
    String line = br.readLine();
    String[] stringInput = new String[100]; // could have represented this as a local constant.
    int stringCount = 0;

    while (line != null) { // We could check here that stringCount < max so that we only take the first n strings, and process those, rather than throwing an error when we have too many strings.
                           // In particular if we were going to throw an error then we should make it a more obvious error than an index out of bounds exception, by manually throwing an exception.
      stringInput[stringCount] = line;
      stringCount++;
      line = br.readLine();
    }

    System.out.println("About to print the strings in reverse:");
    for (--stringCount; stringCount >= 0; --stringCount) {
      System.out.println(stringInput[stringCount]);
    }
  }

  // More general version allowing arbitrarily many strings to be stored.
  // We are using the deque as a stack.
  private static void version2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine(); // this line should probably come just before the loop
    Deque<String> stringInput = new ArrayDeque<>(); // we can/should define this as final because we are not going to move the reference.

    while (line != null) {
      stringInput.push(line);
      line = br.readLine();
    }

    System.out.println("About to print the strings in reverse:");
    while (!stringInput.isEmpty()) {
      System.out.println(stringInput.pop()); // good.
    }
  }

}

// From this question I have learnt:
//    - BufferedReader, InputStreamReader
//    - Deque; ArrayDeque
