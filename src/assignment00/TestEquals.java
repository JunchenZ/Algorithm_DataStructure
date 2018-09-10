package assignment00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEquals {

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
    assertTrue(v1.equals(new Vector3D(3, 3, 3)));
    assertFalse(v1.equals(new Vector3D(3.1, 3, 3)));
  }

  @Test
  public void largeElements() {
    assertTrue(v2.equals(new Vector3D(9000.3245, 23400.54, 357013.567)));
    assertFalse(v2.equals(new Vector3D(9000.3645, 23400.74, 357013.867)));
  }

  @Test
  public void negativeElements() {
    assertTrue(v3.equals(new Vector3D(-6, -3, -98)));
    assertFalse(v3.equals(new Vector3D(-7, -3, -98)));
  }

  @Test
  public void maxValueElements() {
    assertTrue(v4.equals(new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
    assertFalse(v4.equals(new Vector3D(0, Double.MAX_VALUE, Double.MAX_VALUE)));
  }

}
