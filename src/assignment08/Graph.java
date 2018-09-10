package assignment08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

  private Node[][] nodes;
  private int height, width, iStart, jStart, iGoal, jGoal;
  private String inputFile;

  public Graph(String fileName) throws FileNotFoundException {
    inputFile = fileName;
  }

  /**
   * take the data from the file and store them in an array
   * 
   * @param fileName
   * @throws FileNotFoundException
   * 
   */
  public void setNodes() throws FileNotFoundException {
    Scanner s = new Scanner(new FileInputStream(inputFile));
    String[] dimensions = s.nextLine().split(" ");
    height = Integer.parseInt(dimensions[0]);
    width = Integer.parseInt(dimensions[1]);

    nodes = new Node[height][width];
    int i = 0;

    while (s.hasNextLine()) {
      char[] arr = s.nextLine().toCharArray();
      for (int j = 0; j < width; j++) {
        nodes[i][j] = new Node(arr[j], i, j);
        
        if(nodes[i][j].data == 'S') {
          iStart = i;
          jStart = j;
        }else if(nodes[i][j].data == 'G'){
          iGoal = i;
          jGoal = j;
        }
        
      }
      i++;
    }
    s.close();
  }

  /**
   * update the nodes array by the solution path
   */
  public void changeNodes() {
    BFS();
    Node node = nodes[iGoal][jGoal];

    // iterate the cameFrom nodes and update them
    while (node.cameFrom != null) {
      if (node.cameFrom.data == 'S') {
        return;
      }
      node.cameFrom.data = '.';
      node = node.cameFrom;
    }
  }

  /**
   * use breath first search to find the shortest path
   */
  public void BFS() {
    // use LinkedList as a queue, which stores nodes
    LinkedList<Node> queue = new LinkedList<Node>();

    nodes[iStart][jStart].visited = true;
    queue.add(nodes[iStart][jStart]);

    while (!queue.isEmpty()) {
      // dequeue the first item
      Node curr = queue.removeFirst();

      if (curr.data == nodes[iGoal][jGoal].data) {
        return;
      }
      /* go through each neighbor of the current node for those not visited and not a
       * wall, set them as visited, set cameFrom node to current node and enqueue the node 
       */
      for(int i = curr.i - 1; i <= curr.i + 1; i++) {
        for(int j = curr.j - 1; j <= curr.j + 1; j++) {
          if(Math.abs((i + j) - (curr.i + curr.j)) == 1 && i != 0 && i != height-1 && j != 0 && j!= width -1) {
            if(nodes[i][j].data != 'X' && !nodes[i][j].visited) {
              nodes[i][j].visited = true;
              nodes[i][j].cameFrom = curr;
              queue.add(nodes[i][j]);
            }
          }     
        }
      }
    }      
    return;
  }
  
  public void writeToFile(String fileName) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(fileName);
    pw.println(height + " " + width);

    // print the data in the array
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pw.print(nodes[i][j].data);
      }
      pw.println();
    }
    pw.close();
  }

}
