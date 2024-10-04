package io.github.nathanjrussell.matrixlib;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size) throws MatrixExceptions {
        super(size, size);
    }

    public SquareMatrix(int[][] data) throws MatrixExceptions {
        super(data);
        if (numRows != numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
    }

    public SquareMatrix add(SquareMatrix A) throws MatrixExceptions {
        return (SquareMatrix) super.add(A);
    }

    public SquareMatrix subtract(SquareMatrix A) throws MatrixExceptions {
        return (SquareMatrix) super.subtract(A);
    }

    public int getSize() {
        return numRows;
    }

    public SquareMatrix power(int n) throws MatrixExceptions {
        if (n < 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_POWER);
        }
        if (n == 0) {
            return new IdentityMatrix(numRows);
        }
        Matrix result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return new SquareMatrix(result.data);
    }
}

