package assignment08;

public class Node {

   char data;
   boolean visited;
   Node cameFrom;
   int i, j;   
   public Node(char data, int i, int j) {
     this.data = data;
     visited = false;
     this.i = i;
     this.j = j;
   }
   
}
