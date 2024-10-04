package io.github.nathanjrussell.matrixlib;

public interface SquareMatrixInterface extends MatrixInterface {
    int getSize(); //This method will return the size of the square matrix
    SquareMatrix power(int n) throws MatrixExceptions; //This method will return the square matrix raised to the power of n
    int determinant() throws MatrixExceptions; //This method will return the determinant of the square matrix
    public static SquareMatrix identity(int size) throws MatrixExceptions {
        if (size <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
        int[][] data = new int[size][size];
        for (int i = 0; i < size; i++) {
            data[i][i] = 1;
        }
        return new SquareMatrix(data);
    }


    public static int determinant(SquareMatrix A) throws MatrixExceptions {
        //full code
        if (A.numRows == 1) {
            return A.data[0][0];
        }
        if (A.numRows == 2) {
            return A.data[0][0] * A.data[1][1] - A.data[0][1] * A.data[1][0];
        }
        int det = 0;
        int entrySign = 1;
        for (int i = 0; i < A.numRows; i++) {
            det += entrySign * A.data[0][i] * A.minor(0, i).determinant();
            entrySign *= -1;
        }
        return det;
    }
}
