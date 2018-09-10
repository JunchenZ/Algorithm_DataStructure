package assignment00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMagnitude {

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
    assertTrue(Math.abs(v1.getMagnitude() - 5.196) < 0.001);
  }

  @Test
  public void largeElements() {
    assertTrue(Math.abs(v2.getMagnitude() - 357892.831) < 0.001);
  }

  @Test
  public void negativeElements() {
    assertTrue(Math.abs(v3.getMagnitude() - 98.229) < 0.001);
  }

  @Test
  public void maxValueElements() {
    assertTrue(Math.abs(v4.getMagnitude() - Math.sqrt(3 * Double.MAX_VALUE * Double.MAX_VALUE)) < 0.001);
  }

}
