package lec04;

public abstract class Shape {
  public String name;

  public Shape(String n) {
    name = n;
  }

  public String toString() {
    return name;
  }

  public abstract double computeArea();
}
