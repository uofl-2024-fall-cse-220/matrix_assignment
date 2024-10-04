package io.github.nathanjrussell.matrixlib;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size) {
        super(size, size);
    }

    public SquareMatrix(int[][] data) {
        super(data);
        if (rows != cols) {
            throw new IllegalArgumentException("Data must form a square matrix.");
        }
    }

    public SquareMatrix add(SquareMatrix A) {
        return (SquareMatrix) super.add(A);
    }

    public SquareMatrix subtract(SquareMatrix A) {
        return (SquareMatrix) super.subtract(A);
    }



    public SquareMatrix power(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Power must be a non-negative integer.");
        }
        if (n == 0) {
            return new IdentityMatrix(rows);
        }
        Matrix result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return new SquareMatrix(result.data);
    }
}

