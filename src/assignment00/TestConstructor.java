package assignment00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestConstructor {

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
    assertEquals("(3.0, 3.0, 3.0)", v1.toString());
  }

  @Test
  public void largeElements() {
    assertEquals("(9000.3245, 23400.54, 357013.567)", v2.toString());
  }

  @Test
  public void negativeElements() {
    assertEquals("(-6.0, -3.0, -98.0)", v3.toString());
  }

  @Test
  public void maxValueElements() {
    String s = new String("(" + Double.MAX_VALUE + ", " + Double.MAX_VALUE + ", " + Double.MAX_VALUE + ")");
    assertEquals(s, v4.toString());
  }

}
