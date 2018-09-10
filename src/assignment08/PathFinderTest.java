package assignment08;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class PathFinderTest {
  
  @Before
  public void setUp() throws Exception {
    PathFinder.solveMaze("bigMaze.txt", "bigMazeResult.txt");
    PathFinder.solveMaze("classic.txt", "classicResult.txt");
    PathFinder.solveMaze("demoMaze.txt", "demoMazeResult.txt");
    PathFinder.solveMaze("mediumMaze.txt", "mediumMazeResult.txt");
    PathFinder.solveMaze("randomMaze.txt", "randomMazeResult.txt");
    PathFinder.solveMaze("straight.txt", "straightResult.txt");
    PathFinder.solveMaze("tinyMaze.txt", "tinyMazeResult.txt");
    PathFinder.solveMaze("tinyOpen.txt", "tinyOpenResult.txt");
    PathFinder.solveMaze("turn.txt", "turnResult.txt");
    PathFinder.solveMaze("unsolvable.txt", "unsolvableResult.txt");
  }

  @Test
  public void testBigMaze() throws IOException {
    assertTrue(compareFiles("bigMazeResult.txt", "bigMazeSol.txt"));
  }
  
  @Test
  public void testClassic() throws IOException {
    assertTrue(compareFiles("classicResult.txt", "classicSol.txt"));
  }
  
  @Test
  public void testDemoMaze() throws IOException {
    assertTrue(compareFiles("demoMazeResult.txt", "demoMazeSol.txt"));
  }
  
  @Test
  public void testMediumMaze() throws IOException {
    assertTrue(compareFiles("mediumMazeResult.txt", "mediumMazeSol.txt"));
  }
  
  @Test
  public void testRandomMaze() throws IOException {
    assertTrue(compareFiles("randomMazeResult.txt", "randomMazeSol.txt"));
  }
  
  @Test
  public void testStraight() throws IOException {
    assertTrue(compareFiles("straightResult.txt", "straightSol.txt"));
  }
  
  @Test
  public void testTinyMaze() throws IOException {
    assertTrue(compareFiles("tinyMazeResult.txt", "tinyMazeSol.txt"));
  }
  
  @Test
  public void testTinyOpen() throws IOException {
    assertTrue(compareFiles("tinyOpenResult.txt", "tinyOpenSol.txt"));
  }
  
  @Test
  public void testTurn() throws IOException {
    assertTrue(compareFiles("turnResult.txt", "turnSol.txt"));
  }
  
  @Test
  public void testUnsolvable() throws IOException {
    assertTrue(compareFiles("unsolvableResult.txt", "unsolvableSol.txt"));
  }
  
  public boolean compareFiles(String result, String expected) throws IOException {
    return calculateDots(result) == calculateDots(expected);
  }
  
  /**
   * @param fileName
   * @return
   * @throws IOException
   * 
   * calculate and return the number of dot in the file
   */
  public int calculateDots(String fileName) throws IOException {
    Scanner s = new Scanner(new FileInputStream(fileName));
    int height = Integer.parseInt(s.nextLine().split(" ")[0]);
    
    String[] arr = new String[height];
    int i = 0;
    
    while(s.hasNextLine()) {
      arr[i] = s.nextLine();
      i++;
    }
    
    int num = 0;
    for(int j = 0; j < height-1; j++) {
      char[] c = arr[j].toCharArray();
      for(int k = 0; k < c.length; k++) {
        if(c[k] == '.') {
          num++;
        }
      }
    }
    
    s.close();
    return num;
  }

}
