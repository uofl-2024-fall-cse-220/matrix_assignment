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
        return multiply(this, scalar);
    }

    public SquareMatrix transpose()  {
        Matrix result = super.transpose();
        return new SquareMatrix(result.data);
    }

    public int determinant()  {
        return SquareMatrixInterface.determinant(this);
    }


    public SquareMatrix minor(int row, int col)  {
        return new SquareMatrix(MatrixInterface.minor(this, row, col).data);
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

