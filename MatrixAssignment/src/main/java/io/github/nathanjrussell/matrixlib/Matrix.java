package io.github.nathanjrussell.matrixlib;

public class Matrix implements MatrixInterface {
    //private may not be the best option here.
    // We only need to prevent external classes from modifying the variables directly
    private int numRows;
    private int numCols;
    private int[][] data;

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
        return data[i][i];
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
        data[j][j] = value;
    }
    // Static Methods for Operations


    public Matrix minor(int row, int col)  {
        return new Matrix(MatrixInterface.minor(this, row, col).data);
    }


    public Matrix transpose()   {
        return MatrixInterface.transpose(this);
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
