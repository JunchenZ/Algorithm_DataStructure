/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixJUnitTester {

  Matrix threeByTwo, twoByThree, twoByTwoResult;
  /* Initialize some matrices we can play with for every test! */

  @Before
  public void setup() {
    twoByThree = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } }); //should be two by three?????
    threeByTwo = new Matrix(new int[][] { { 4, 5 }, { 3, 2 }, { 1, 1 } }); //should be three by two?
    // this is the known correct result of multiplying M1 by M2
    twoByTwoResult = new Matrix(new int[][] { { 13, 12 }, { 29, 26 } });
  }

  @Test
  public void equalsWithWrongType() {
    Assert.assertFalse(twoByThree.equals(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } }));
  }
  
  @Test
  public void equalsWithBalancedDimensions() {
    Assert.assertTrue(twoByThree.equals(new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } })));
    Assert.assertFalse(threeByTwo.equals(new Matrix(new int[][] { { 3, 5 }, { 3, 2 }, { 1, 1 } }))) ;
  }
  
  @Test
  public void equalsWithUnbalancedDimensions() {
    Assert.assertFalse(threeByTwo.equals(twoByThree));
    Assert.assertFalse(twoByThree.equals(twoByTwoResult)) ;
  }
  
  @Test
  public void twoByTwoToString() {
    String resultString = "13 12 \n29 26 \n";
    Assert.assertEquals(resultString, twoByTwoResult.toString());
  }
  
  @Test
  public void twoByThreeToString() {
    String resultString = "1 2 3 \n2 5 6 \n";
    Assert.assertEquals(resultString, twoByThree.toString());
  }
  
  @Test
  public void timesWithBalancedDimensions() {
    Matrix matrixProduct = twoByThree.times(threeByTwo); 
    Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
  }

  @Test
  public void timesWithUnbalancedDimensions() {
    Matrix matrixProduct = threeByTwo.times(threeByTwo);
    Assert.assertTrue(matrixProduct==null);
  }
  
  @Test
  public void plusWithBalancedDimensions() {
    Matrix matrixSum = twoByTwoResult.plus(twoByTwoResult); 
    Assert.assertTrue(matrixSum.toString().equals("26 24 \n58 52 \n"));
  }

  @Test
  public void plusWithUnbalancedDimensions() {
    Matrix matrixSum = threeByTwo.plus(twoByThree);
    Assert.assertTrue(matrixSum==null);
  }
   
}
