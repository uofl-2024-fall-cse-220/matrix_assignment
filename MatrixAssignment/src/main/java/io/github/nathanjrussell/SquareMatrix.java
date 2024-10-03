package io.github.nathanjrussell;

public class SquareMatrix extends Matrix {
    SquareMatrix(int size) {
        super(size, size);
    }

    SquareMatrix(int[][] matrix) throws MatrixExceptions {
        super(matrix);
        if (matrix.length != matrix[0].length) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
    }
}
