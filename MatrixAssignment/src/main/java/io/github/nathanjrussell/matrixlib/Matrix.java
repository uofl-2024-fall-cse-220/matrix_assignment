package io.github.nathanjrussell.matrixlib;

public class Matrix implements MatrixInterface {
    protected int numRows;
    protected int numCols;
    protected int[][] data;

    // Constructors
    public Matrix(int numRows, int numCols)  {
        this.numRows = numRows;
        this.numCols = numCols;
        if (numRows == numCols && numRows <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
        if (numRows <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_NUM_ROWS);
        }
        if (numCols <= 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_NUM_COLS);
        }
        this.data = new int[numRows][numCols];
    }

    public Matrix(int[][] data)  {
        this.numRows = data.length;
        this.numCols = data[0].length;
        for (int i = 1; i < numRows; i++) {
            if (data[i].length != numCols) {
                throw new MatrixExceptions(MatrixValidationErrorEnum.NOT_ALL_ROWS_SAME_LENGTH);
            }
        }
        this.data = data;
    }

    public int getEntry(int i, int j)  {
        if (i < 0 || i >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (j < 0 || j >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        return data[i][j];
    }


    public int getNumRows() {
        return numRows;
    }


    public int getNumCols() {
        return numCols;
    }

    public void setEntry(int i, int j, int value)  {
        if (i < 0 || i >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (j < 0 || j >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        data[i][j] = value;
    }
    // Static Methods for Operations
    public static Matrix add(Matrix A, Matrix B)  {
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

    public static Matrix subtract(Matrix A, Matrix B)  {
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

    public static Matrix multiply(Matrix A, int scalar)  {
        Matrix result = new Matrix(A.numRows, A.numCols);
        for (int i = 0; i < A.numRows; i++) {
            for (int j = 0; j < A.numCols; j++) {
                result.data[i][j] = A.data[i][j] * scalar;
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix A, Matrix B)  {
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

    public Matrix transpose()  {
        Matrix result = new Matrix(numCols, numRows);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.data[j][i] = data[i][j];
            }
        }
        return result;
    }

    // Instance Methods that utilize Static Methods
    public Matrix add(Matrix A)  {
        return add(this, A);
    }

    public Matrix subtract(Matrix A)  {
        return subtract(this, A);
    }

    public Matrix multiply(Matrix A)  {
       return multiply(this, A);
    }

    public Matrix multiply(int scalar)  {
        return multiply(this, scalar);
    }




}
