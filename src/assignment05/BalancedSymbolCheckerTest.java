package assignment05;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class BalancedSymbolCheckerTest {

  private String[] str;
  private BalancedSymbolChecker bsc;

  @Before
  public void setUp() throws Exception {
    str = new String[10];
    for (int i = 0; i < 10; i++) {
      str[i] = "Class" + Integer.toString(i + 1) + ".java";
    }
    bsc = new BalancedSymbolChecker();
  }

  @Test
  public void test1() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.",
        bsc.checkFile(str[0]));
  }

  @Test
  public void test2() throws FileNotFoundException {
    assertEquals("No errors found. All symbols match.", bsc.checkFile(str[1]));
  }

  @Test
  public void test3() throws FileNotFoundException {
    assertEquals("No errors found. All symbols match.", bsc.checkFile(str[2]));
  }

  @Test
  public void test4() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.",
        bsc.checkFile(str[3]));
  }

  @Test
  public void test5() throws FileNotFoundException {
    assertEquals("No errors found. All symbols match.", bsc.checkFile(str[4]));
  }

  @Test
  public void test6() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.",
        bsc.checkFile(str[5]));
  }

  @Test
  public void test7() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.",
        bsc.checkFile(str[6]));
  }

  @Test
  public void test8() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.",
        bsc.checkFile(str[7]));
  }

  @Test
  public void test9() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.",
        bsc.checkFile(str[8]));
  }

  @Test
  public void test10() throws FileNotFoundException {
    assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.", bsc.checkFile(str[9]));
  }

}
