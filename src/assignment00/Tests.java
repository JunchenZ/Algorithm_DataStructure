package assignment00;

public class Tests {

  public static void Test(String message, String expected, String result) {
    System.out.println("Test: " + message);

    if (expected.equals(result)) { // if two strings are equal, then the test is passed
      System.out.println("\tPASSED");
    } else {
      // if the test is failed then show the expected result and the actual result
      System.out.println("\tFAILED, expected: \"" + expected + "\", got: \"" + result + "\"");
    }
  }

  public static void Test(String message, double expected, double result) {
    System.out.println("Test: " + message);

    // set a precision of 10^-3 for comparing two double values
    // if the difference between two double values < 10^(-3), then they are equal
    if (Math.abs(expected - result) < Math.pow(10, -3)) {
      System.out.println("\tPASSED");
    } else {
      // show the expected result and the actual result
      System.out.println("\tFAILED, expected: \"" + expected + "\", got: \"" + result + "\"");
    }
  }

  public static void Test(String message, Vector3D expected, Vector3D result) {
    System.out.println("Test: " + message);

    // after testing the equals() method, it can be used to determine if two objects
    // are equal or not
    if (expected.equals(result)) {
      System.out.println("\tPASSED");
    } else {
      // show the expected result and the actual result
      System.out.println("\tFAILED, expected: \"" + expected.toString() + "\", got: \"" + result.toString() + "\"");
    }
  }

  public static void TestConstructors() {
    String result = "";

    // test constructor in different cases
    Vector3D v1 = new Vector3D(0, 2, 3);
    result = v1.toString();
    Test("constructor and toString", "(0.0, 2.0, 3.0)", result);

    Vector3D v2 = new Vector3D(0.0, 4.3, 5);
    result = v2.toString();
    Test("constructor and toString", "(0.0, 4.3, 5.0)", result);

    Vector3D v3 = new Vector3D(-0, -6, -7.8);
    result = v3.toString();
    Test("constructor and toString", "(0.0, -6.0, -7.8)", result);
  }

  public static void TestMagnitude() {
    double result;

    // test getMagnitude() method in different cases
    Vector3D v1 = new Vector3D(0, 4, 3);
    result = v1.getMagnitude();
    Test("getMagnitude", 5, result);

    Vector3D v2 = new Vector3D(2, -1, 5);
    result = v2.getMagnitude();
    Test("getMagnitude", 5.477, result);

    Vector3D v3 = new Vector3D(-2.6, 7.1, 9.8);
    result = v3.getMagnitude();
    Test("getMagnitude", 12.378, result);
  }

  public static void TestEquals() {
    // test equals() method in different cases
    Vector3D v1 = new Vector3D(0, 4, -3);
    Vector3D v2 = new Vector3D(0.0, 4, -3);
    System.out.println("Test: equals");
    if (v1.equals(v2)) {
      System.out.println("\tPASSED");
    } else {
      System.out.println("\tFAILED, expected: equal, got: not equal");
    }

    Vector3D v3 = new Vector3D(7, -5, 9);
    Vector3D v4 = new Vector3D(7, -5, 9.01);
    System.out.println("Test: equals");
    if (!v3.equals(v4)) {
      System.out.println("\tPASSED");
    } else {
      System.out.println("\tFAILED, expected: not equal, got: equal");
    }

    Vector3D v5 = new Vector3D(6, 3.3, -0);
    Vector3D v6 = new Vector3D(6.0, 3.3, 0);
    System.out.println("Test: equals");
    if (v5.equals(v6)) {
      System.out.println("\tPASSED");
    } else {
      System.out.println("\tFAILED, expected: not equal, got: equal");
    }
  }

  public static void TestPlus() {
    Vector3D vResult;
    Vector3D vExpected;

    // test plus() method in different cases
    Vector3D v1 = new Vector3D(0, 4, 3);
    Vector3D v2 = new Vector3D(7, 5, 8);
    vResult = v1.plus(v2);
    vExpected = new Vector3D(7.0, 9.0, 11.0);
    Test("plus", vExpected, vResult);

    Vector3D v3 = new Vector3D(-3, 9, 2.6);
    Vector3D v4 = new Vector3D(0, 1.2, -7.8);
    vResult = v3.plus(v4);
    vExpected = new Vector3D(-3.0, 10.2, -5.2);
    Test("plus", vExpected, vResult);

    Vector3D v5 = new Vector3D(14.6, 54.5, 65.8);
    Vector3D v6 = new Vector3D(-5.9, 19.5, -9.6);
    vResult = v5.plus(v6);
    vExpected = new Vector3D(8.7, 74.0, 56.2);
    Test("plus", vExpected, vResult);
  }

  public static void TestTimes() {
    Vector3D vResult;
    Vector3D vExpected;

    // test times() method in different cases
    Vector3D v1 = new Vector3D(0, 4, 3);
    Vector3D v2 = new Vector3D(7, 5, 8);
    vResult = v1.times(v2);
    vExpected = new Vector3D(17.0, 21.0, -28.0);
    Test("times", vExpected, vResult);

    Vector3D v3 = new Vector3D(-3, 9, 2.6);
    Vector3D v4 = new Vector3D(0, 1.2, -7.8);
    vResult = v3.times(v4);
    vExpected = new Vector3D(-73.32, -23.4, -3.6);
    Test("times", vExpected, vResult);

    Vector3D v5 = new Vector3D(14.6, 54.5, 65.8);
    Vector3D v6 = new Vector3D(-5.9, 19.5, -9.6);
    vResult = v5.times(v6);
    vExpected = new Vector3D(-1806.3, -248.06, 606.25);
    Test("times", vExpected, vResult);
  }

  public static void main(String[] args) {
    // call the test functions which will show the test results
    TestConstructors();
    TestMagnitude();
    TestEquals();
    TestPlus();
    TestTimes();
  }

}
