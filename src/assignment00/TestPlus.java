package assignment00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlus {

  private Vector3D v1, v2, v3, v4;

  @Before
  public void setUp() throws Exception {
    v1 = new Vector3D(3, 3, 3);
    v2 = new Vector3D(9000.3245, 23400.54, 357013.567);
    v3 = new Vector3D(-6, -3, -98);
    v4 = new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
  }

  @After
  public void tearDown() throws Exception {
  }

  // @Test
  // public void test() {
  // fail("Not yet implemented");
  // }

  @Test
  public void allElementsEqual() {
    assertEquals(new Vector3D(6.0, 6.0, 6.0), v1.plus(v1));
  }

  @Test
  public void largeElements() {
    assertEquals(new Vector3D(9003.3245, 23403.54, 357016.567), v2.plus(v1));
  }

  @Test
  public void negativeElements() {
    assertEquals(new Vector3D(-3.0, 0.0, -95.0), v3.plus(v1));
  }

  @Test
  public void maxValueElements() {
    assertEquals(new Vector3D(2 * Double.MAX_VALUE, 2 * Double.MAX_VALUE, 2 * Double.MAX_VALUE), v4.plus(v4));
  }

}
