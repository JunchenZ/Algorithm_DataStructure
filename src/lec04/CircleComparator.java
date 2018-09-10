package lec04;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

  public int compare(Circle arg0, Circle arg1) {
    if (arg0.radius > arg1.radius)
      return 1;

    if (arg0.radius < arg1.radius)
      return -1;

    return 0;
  }
}
