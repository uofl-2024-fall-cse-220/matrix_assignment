package io.github.nathanjrussell.matrixlib;

public interface MatrixInterface {
    void setEntry(int row, int col, int value) throws MatrixExceptions; //This method will set/update a value in a specific row nad column
    int getEntry(int row, int col) throws  MatrixExceptions; //This method will get the value in a specific row and column

    int getNumRows(); //This method will return the number of rows  in the matrix
    int getNumCols(); //This method will return the number of columns in the matrix

    Matrix add(Matrix other) throws MatrixExceptions; //This method will add two matrices
    Matrix subtract(Matrix other) throws MatrixExceptions; //This method will subtract two matrices
    Matrix multiply(Matrix other) throws MatrixExceptions; //This method will multiply two matrices
    Matrix multiply(int scalar) throws MatrixExceptions; //This method will multiply a matrix by a scalar

    public static Matrix transpose(Matrix A)  {
        Matrix result = new Matrix(A.numCols, A.numRows);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[j][i] = A.data[i][j];
            }
        }
        return result;
    }

    public static Matrix add(Matrix A, Matrix B) throws MatrixExceptions {
        if (A.numRows != B.numRows || A.numCols != B.numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT);
        }
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix A, Matrix B) throws MatrixExceptions {
        if (A.numRows != B.numRows || A.numCols != B.numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT);
        }
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] - B.data[i][j];
            }
        }
        return result;
    }

    //Multiplication is common to all matrices so it is implemented here
    public static Matrix multiply(Matrix A, int scalar)  {
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] * scalar;
            }
        }
        return result;
    }

    //Addition is common to all matrices so it is implemented here
    public static Matrix multiply(Matrix A, Matrix B)  throws MatrixExceptions {
        if (A.numCols != B.numRows ) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_MULTIPLY);
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

    //All matrices can have minors so it is implemented here
    public static Matrix minor(Matrix A, int row, int col) throws MatrixExceptions {
        if (row < 0 || row >= A.numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (col < 0 || col >= A.numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        int[][] data = new int[A.numRows - 1][A.numCols - 1];
        for (int i = 0; i < A.numRows; i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0; j < A.numCols; j++) {
                if (j == col) {
                    continue;
                }
                int newRow = i < row ? i : i - 1;
                int newCol = j < col ? j : j - 1;
                data[newRow][newCol] = A.data[i][j];
            }
        }
        return new Matrix(data);
    }
}
