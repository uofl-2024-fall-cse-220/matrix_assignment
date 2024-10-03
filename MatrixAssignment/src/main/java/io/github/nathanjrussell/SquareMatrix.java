package io.github.nathanjrussell;

public class SquareMatrix extends Matrix implements SquareMatrixInterface {
    SquareMatrix(int size) {
        super(size, size);
    }

    SquareMatrix(int[][] matrix) throws MatrixExceptions {
        super(matrix);
        if (matrix.length != matrix[0].length) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
    }

    public int getSize() {
        return getNumRows();
    }

    public SquareMatrix power(int n) throws MatrixExceptions {
        if (n < 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_POWER);
        }
        if (n == 0) {
            return new IdentityMatrix(getSize());
        }
        SquareMatrix result = new SquareMatrix(getSize());
        for (int i = 1; i < n; i++) {
            result = (SquareMatrix) result.multiply(this);
        }
        return result;
    }

}
