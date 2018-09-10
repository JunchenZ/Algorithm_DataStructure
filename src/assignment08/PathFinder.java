package assignment08;

import java.io.FileNotFoundException;

public class PathFinder {

  public static void solveMaze(String inputFile, String outputFile) throws FileNotFoundException {
    // graph stores the data of inputFile in an array
    Graph graph = new Graph(inputFile);
    
    graph.setNodes();
    graph.changeNodes();
    
    graph.writeToFile(outputFile);
  }

}
