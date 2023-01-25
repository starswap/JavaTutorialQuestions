package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {
  public static void main(String[] args) throws IOException {
    System.out.println("About to do something cool.");
    BufferedReader br = new BufferedReader(new FileReader("src/examples/FileExample.java"));
    String line = br.readLine();
    while (line != null) {
      System.out.println(line);
      line = br.readLine();
    }
  }
}
