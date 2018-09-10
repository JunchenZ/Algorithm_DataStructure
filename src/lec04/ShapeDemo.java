package lec04;

public class ShapeDemo {

  public static void main(String[] args) {

    // Demo part 1
    Shape shape = new Circle(1.5);
    System.out.println(shape);

    // Demo part 2
    Shape[] shapes = new Shape[3];
    shapes[0] = new Circle(3.0);
    shapes[1] = new Rectangle(5.2, 1.7);
    shapes[2] = new Square(2.5);

    // Two different versions of the same loop
    for(int i=0; i < 3; i++)
      System.out.println(shapes[i] + " with area " + shapes[i].computeArea());

    for (Shape s : shapes) // "enhanced" version
      System.out.println(s + " with area " + s.computeArea());

    // Demo part 3
    Shape s1 = new Circle(1.5);
    Shape s2 = new Rectangle(1.6, 7.0);
    System.out.println(isLarger(s1, s2));

  }

  public static boolean isLarger(Shape a, Shape b) {
    return a.computeArea() > b.computeArea();
  }
}
