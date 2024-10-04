package io.github.nathanjrussell.matrixlib;

import java.util.Arrays;

public class Matrix implements MatrixInterface {
    protected int numRows;
    protected int numCols;
    protected int[][] data;

    // Constructors
    public Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.data = new int[numRows][numCols];
    }

    public Matrix(int[][] data) {
        this.numRows = data.length;
        this.numCols = data[0].length;
        this.data = data;
    }

    public int getEntry(int i, int j) {
        return data[i][j];
    }


    public int getNumRows() {
        return numRows;
    }


    public int getNumCols() {
        return numCols;
    }

    public void setEntry(int i, int j, int value) {
        data[i][j] = value;
    }
    // Static Methods for Operations
    public static Matrix add(Matrix A, Matrix B) {
        if (A.numRows != B.numRows || A.numCols != B.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix A, Matrix B) {
        if (A.numRows != B.numRows || A.numCols != B.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] - B.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.numCols != B.numRows) {
            throw new IllegalArgumentException("Matrices dimensions do not match for multiplication.");
        }
        Matrix result = new Matrix(A.numRows, B.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < B.numCols; j++) {
                for (int k = 0; k < A.numCols; k++) {
                    result.data[i][j] += A.data[i][k] * B.data[k][j];
                }
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(numCols, numRows);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.data[j][i] = data[i][j];
            }
        }
        return result;
    }

    // Instance Methods that utilize Static Methods
    public Matrix add(Matrix A) {
        return add(this, A);
    }

    public Matrix subtract(Matrix A) {
        return subtract(this, A);
    }

    public Matrix multiply(Matrix A) {
       Matrix result = new Matrix(this.numRows, A.numCols);
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                for (int k = 0; k < this.numCols; k++) {
                    result.data[i][j] += this.data[i][k] * A.data[k][j];
                }
            }
        }
        return result;
    }



    // Helper method for creating an identity matrix
    public static Matrix identity(int size) {
        return new IdentityMatrix(size);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }
}
