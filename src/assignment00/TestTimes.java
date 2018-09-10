package assignment00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTimes {

  private Vector3D v1, v2, v3, v4;

  @Before
  public void setUp() throws Exception {
    v1 = new Vector3D(3, 3, 3);
    v2 = new Vector3D(9000, 23400, 357013);
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
    assertEquals("(0.0, 0.0, 0.0)", v1.times(v1).toString());
  }

  @Test
  public void largeElements() {
    assertEquals(v2.times(v1), new Vector3D(-1000839.0, 1044039.0, -43200.0));
  }

  @Test
  public void negativeElements() {
    assertEquals(v3.times(v1), new Vector3D(285.0, -276.0, -9.0));
  }

  @Test
  public void maxValueElements() {
    assertEquals(v4.times(v3), new Vector3D(95 * Double.MAX_VALUE, -92 * Double.MAX_VALUE, -3 * Double.MAX_VALUE));
  }

}
