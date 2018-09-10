package lec04;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericDemo {

  public static void main(String[] args) {

    ArrayList<Shape> shapes = new ArrayList<Shape>();
    shapes.add(new Circle(2.3));
    shapes.add(new Rectangle(0.5, 2.0));
    shapes.add(new Square(1.5));

    ArrayList<Circle> circles = new ArrayList<Circle>();
    circles.add(new Circle(3.1));
    circles.add(new Circle(0.1));
    circles.add(new Circle(1.4));

    System.out.println("total area of shapes is " + totalArea(circles));
    System.out.println("total area of shapes is " + totalArea(shapes));

    System.out.println("biggest circle by radius " + findMax(circles, new CircleComparator()));
// Uncomment this line
//    System.out.println("biggest circle by name " + findMax(circles, new ShapeComparator()));
  }

  // Part 1
  public static double totalArea(ArrayList<? extends Shape> list) {
    double total = 0;
    for (int i = 0; i < list.size(); i++)
      total += list.get(i).computeArea();
    return total;
  }

  // Part 2
  public static <T> T findMax(ArrayList<T> list, Comparator<T> cmp) // first attempt
  // public static <T> T findMax(ArrayList<T> list, Comparator<? super T> cmp) // fixed
  {
    T max = list.get(0);
    for (int i = 0; i < list.size(); i++)
      if (cmp.compare(max, list.get(i)) < 0)
        max = list.get(i);
    return max;
  }
}
