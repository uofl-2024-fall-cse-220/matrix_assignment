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


}
