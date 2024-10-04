package io.github.nathanjrussell.matrixlib;

import java.util.Arrays;

public class Matrix {
    protected int rows;
    protected int cols;
    protected int[][] data;

    // Constructors
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public int getEntry(int i, int j) {
        return data[i][j];
    }

    public void setEntry(int i, int j, int value) {
        data[i][j] = value;
    }
    // Static Methods for Operations
    public static Matrix add(Matrix A, Matrix B) {
        if (A.rows != B.rows || A.cols != B.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        Matrix result = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                result.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix A, Matrix B) {
        if (A.rows != B.rows || A.cols != B.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        Matrix result = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                result.data[i][j] = A.data[i][j] - B.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.cols != B.rows) {
            throw new IllegalArgumentException("Matrices dimensions do not match for multiplication.");
        }
        Matrix result = new Matrix(A.rows, B.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.cols; j++) {
                for (int k = 0; k < A.cols; k++) {
                    result.data[i][j] += A.data[i][k] * B.data[k][j];
                }
            }
        }
        return result;
    }

    public static Matrix power(Matrix A, int exponent) {
        if (A.rows != A.cols) {
            throw new IllegalArgumentException("Only square matrices can be raised to a power.");
        }
        Matrix result = identity(A.rows); // Start with identity matrix
        Matrix base = A;

        for (int i = 0; i < exponent; i++) {
            result = multiply(result, base);
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
       Matrix result = new Matrix(this.rows, A.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
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
