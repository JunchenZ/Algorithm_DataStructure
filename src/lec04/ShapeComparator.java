package lec04;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {

	public int compare(Shape o1, Shape o2) {
		return o1.name.compareTo(o2.name);
	}
	
}
