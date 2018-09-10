package lec04;

public class Rectangle extends Shape {
  double length, width;

  public Rectangle(double l, double w) {
    super("Rectangle");
    length = l;
    width = w;
  }

  @Override
  public double computeArea() {
    return length * width;
  }

  public String toString() {
    return super.toString() + " with length " + length + " and width " + width;
  }

}
