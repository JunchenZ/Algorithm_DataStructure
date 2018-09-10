package assignment06;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SpellCheckerTest {

  SpellChecker mySC;
  File dic, f1, f2, f3, f4;
  
  @Before
  public void setUp() throws Exception {
    dic = new File("dictionary.txt");
    mySC = new SpellChecker(dic);
    
    f1 = new File("test_no_mis_1.txt");
    f2 = new File("test_no_mis_2.txt");
    f3 = new File("test_mis_1.txt");
    f4 = new File("test_mis_2.txt");
  }

  @Test
  public void testDictionary() {
    assertEquals("passed", run_spell_check(dic, 0));
  }
  
  @Test
  public void test1() {
    assertEquals("passed", run_spell_check(f1, 1));
  }
  
  @Test
  public void test2() {
    assertEquals("passed", run_spell_check(f2, 2));
  }
  
  @Test
  public void test3() {
    assertEquals("failed", run_spell_check(f3, 3));
  }
  
  @Test
  public void test4() {
    assertEquals("failed", run_spell_check(f4, 4));
  }
    
  public String run_spell_check(File file, int testNum) {
    List<String> misspelledWords = mySC.spellCheck(file);
    if(misspelledWords.size() == 0) {
      return "passed";
    }else {
      System.out.println("test " + testNum);
      for(String str : misspelledWords) {
        System.out.println(str);
      }     
      return "failed";
    }
  }

}
