package assignment05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 */
public class BalancedSymbolChecker {

  /**
   * Returns a message indicating whether the input file has unmatched symbols.
   * (Use the methods below for constructing messages.) Throws
   * FileNotFoundException if the file does not exist.
   */
  public String checkFile(String filename) throws FileNotFoundException {
    Scanner s = new Scanner(new FileInputStream(filename));
    LinkedListStack<Character> lls = new LinkedListStack<Character>();
    int line = 0;

    while (s.hasNextLine()) {
      line++;
      char[] arr = s.nextLine().toCharArray();

      for (int i = 0; i < arr.length; i++) {
        char ch = arr[i];
        if (ch == '(' || ch == '[' || ch == '{') {
          lls.push(ch);
        } else if (ch == ')' || ch == ']' || ch == '}') {
          if (ch == expectedSymbol((char) lls.peek())) {
            lls.pop();
          } else {
            s.close();
            return unmatchedSymbol(line, i + 1, ch, expectedSymbol((char) lls.peek()));
          }
        } else if (ch == '*' && arr[i - 1] == '/' && (char) lls.peek() != '/') {
          lls.push('/');
        } else if (ch == '/' && arr[i - 1] == '*' && (char) lls.peek() == '/') {
          lls.pop();
        }
      }
    }
    s.close();

    if (!lls.isEmpty()) {
      char c = (char) lls.peek();
      if (c == '/') {
        return unfinishedComment();
      } else {
        return unmatchedSymbolAtEOF(expectedSymbol(c));
      }
    } else {
      return allSymbolsMatch();
    }
  }

  /**
   * Returns an error message for unmatched symbol at the input line and column
   * numbers. Indicates the symbol match that was expected and the symbol that was
   * read.
   */
  private String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
    return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
        + ", but read " + symbolRead + " instead.";
  }

  /**
   * Returns an error message for unmatched symbol at the end of file. Indicates
   * the symbol match that was expected.
   */
  private String unmatchedSymbolAtEOF(char symbolExpected) {
    return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
  }

  /**
   * Returns an error message for a file that ends with an open /* comment.
   */
  private String unfinishedComment() {
    return "ERROR: File ended before closing comment.";
  }

  /**
   * Returns a message for a file in which all symbols match.
   */
  private String allSymbolsMatch() {
    return "No errors found. All symbols match.";
  }

  private char expectedSymbol(char ch) throws NoSuchElementException {
    if (ch == '(') {
      return ')';
    } else if (ch == '[') {
      return ']';
    } else if (ch == '{') {
      return '}';
    } else
      throw new NoSuchElementException();
  }

}
