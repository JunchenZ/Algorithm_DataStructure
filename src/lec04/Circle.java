package lec04;

public class Circle extends Shape {
  public double radius;

  public Circle(double r) {
    super("Circle");
    radius = r;
  }

  public String toString() {
    return super.toString() + " with radius " + radius;
  }

  @Override
  public double computeArea() {
    return Math.PI * radius * radius;
  }
}
