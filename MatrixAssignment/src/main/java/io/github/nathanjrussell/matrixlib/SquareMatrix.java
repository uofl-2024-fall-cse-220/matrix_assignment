package io.github.nathanjrussell.matrixlib;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size)  {
        super(size, size);
    }

    public SquareMatrix(int[][] data)  {
        super(data);
        if (numRows != numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE);
        }
    }

    public SquareMatrix add(SquareMatrix A)  {
        return add(this, A);
    }

    public SquareMatrix subtract(SquareMatrix A)  {
        return subtract(this, A);
    }

    public SquareMatrix multiply(SquareMatrix A)  {
        return multiply(this, A);
    }

    public SquareMatrix multiply(int scalar)  {
    }

    public SquareMatrix transpose()  {
        Matrix result = super.transpose();
        return new SquareMatrix(result.data);
    }

    //The body of this method is fine
    public int determinant()  {
        if (numRows == 1) {
            return data[0][0];
        }
        if (numRows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        int det = 0;
        int entrySign = 1;
        for (int i = 0; i < numRows; i++) {
            det += entrySign * data[0][i] * this.minor(0, i).determinant();
            entrySign *= -1;
        }
        return det;
    }
    //The body of this method is fine
    public SquareMatrix minor(int row, int col)  {
        if (row < 0 || row >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (col < 0 || col >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        int[][] minorData = new int[numRows - 1][numCols - 1];
        int m = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == row) {
                continue;
            }
            int n = 0;
            for (int j = 0; j < numCols; j++) {
                if (j == col) {
                    continue;
                }
                minorData[m][n] = data[i][j];
                n++;
            }
            m++;
        }
        return new SquareMatrix(minorData);
    }

    public int getSize() {
        return numRows;
    }

    //The body of this method is fine
    public SquareMatrix power(int n)  {
        if (n < 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_POWER);
        }
        if (n == 0) {
            return SquareMatrixInterface.identity(numRows);
        }
        Matrix result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return new SquareMatrix(result.data);
    }

}

