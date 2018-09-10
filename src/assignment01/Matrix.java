package assignment01;

import java.util.Arrays;

public class Matrix {
  int numRows;
  int numColumns;
  int data[][];

  // Constructor with data for new matrix (automatically determines dimensions)
  public Matrix(int data[][]) {
    numRows = data.length; // d.length is the number of 1D arrays in the 2D array
    if (numRows == 0) {
      numColumns = 0;
    } else {
      numColumns = data[0].length; // d[0] is the first 1D array
    }
    this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
    // copy the data over
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        this.data[i][j] = data[i][j];
      }
    }
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public boolean equals(Object other) {
    if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
      return false;
    }
    Matrix matrix = (Matrix) other; // if the above was not true, we know it's safe to treat 'o' as a Matrix

    return Arrays.deepEquals(this.data, matrix.data); // placeholder
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
            // the superclass' (Object) version
  public String toString() {
    String matrixString = "";
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        matrixString += data[i][j] + " ";
      }
      matrixString += "\n";
    }
    return matrixString; // placeholder
  }

  public Matrix times(Matrix matrix) {

    if (!(this.numColumns == matrix.numRows)) {
      return null;
    }
    int product[][] = new int[this.numRows][matrix.numColumns];
    for (int i = 0; i < this.numRows; i++) {
      for (int j = 0; j < matrix.numColumns; j++) {
        for (int k = 0; k < this.numColumns; k++) {
          product[i][j] += this.data[i][k] * matrix.data[k][j];
        }
      }
    }
    return new Matrix(product); // placeholder
  }

  public Matrix plus(Matrix matrix) {

    if (!(this.numRows == matrix.numRows && this.numColumns == matrix.numColumns)) {
      return null;
    }
    int sum[][] = new int[numRows][numColumns];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        sum[i][j] = matrix.data[i][j] + this.data[i][j];
      }
    }
    return new Matrix(sum); // placeholder
  }
}
