import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Qf7c3 {

  private static boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
           (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
  }

  private static String wordToPigLatin(String word) {
    if (isDigit(word.charAt(0))) { return word; }
    else if (isVowel(word.charAt(0))) { return word + "ay"; }
    else if (isUpperCase(word.charAt(0))) {
      // get the first letter, lower case it and put on the end, adding ay as necessary.
        return toUpperCase(word.charAt(1))
            + word.substring(2, word.length() - 1)
            + toLowerCase(word.charAt(0)) + "ay";
    }
    else {
        return word.substring(1, word.length() - 1)
            + toLowerCase(word.charAt(0)) + "ay";
    }
  }

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    StringBuilder result = new StringBuilder();
    while (line != null) {
      StringBuilder currWord = new StringBuilder();
      for (int i = 0; i < line.length(); ++i) {
        if (isAlphabetic(line.charAt(i))) {
          currWord.append(line.charAt(i));
        }
        else {
          result.append(wordToPigLatin(currWord.toString()));
          result.append(line.charAt(i));
        }
      }
      result.append(wordToPigLatin(currWord.toString()));
      System.out.println("The result in Pig Latin is: " + result);
      line = reader.readLine();
    }
  }
}
