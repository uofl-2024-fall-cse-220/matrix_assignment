package io.github.nathanjrussell;

public class Matrix implements MatrixInterface  {
    private final int[][] matrix;
    private final int numCols;
    private final int numRows;
    Matrix(int numRows, int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
        matrix = new int[numRows][numCols];
    }

    Matrix(int[][] matrix) {
        this(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, matrix[i].length);
        }
    }
    public int getNumRows() {
        return numRows;
    }
    public int getNumCols() {
        return numCols;
    }
    public void setElement(int row, int col, int value) throws MatrixExceptions {
        if (row < 0 || row >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (col < 0 || col >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        matrix[row][col] = value;
    }
    public int getElement(int row, int col) throws MatrixExceptions {
        if (row < 0 || row >= numRows) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_ROW);
        }
        if (col < 0 || col >= numCols) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_COL);
        }
        return matrix[row][col];
    }

    public void doubleEveryEntry() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= 2;
            }
        }
    }

    public void addOneToEveryEntry() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += 1;
            }
        }
    }

    public Matrix add(Matrix b) throws MatrixExceptions {
        return Matrix.add(this, b);
    }

    public Matrix subtract(Matrix b) throws MatrixExceptions {
        return Matrix.subtract(this, b);
    }

    public Matrix multiply(int scalar) throws MatrixExceptions {
        return Matrix.multiply(this, scalar);
    }

    public Matrix multiply(Matrix b) throws MatrixExceptions {
        return Matrix.multiply(this, b);
    }

    public static Matrix add(Matrix a, Matrix b) throws MatrixExceptions {
        if (a.getNumRows() != b.getNumRows() || a.getNumCols() != b.getNumCols()) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT);
        }
        Matrix result = new Matrix(a.getNumRows(), a.getNumCols());
        for (int i = 0; i < a.getNumRows(); i++) {
            for (int j = 0; j < a.getNumCols(); j++) {
                result.setElement(i, j, a.getElement(i, j) + b.getElement(i, j));
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix a, Matrix b) throws MatrixExceptions {
        if (a.getNumRows() != b.getNumRows() || a.getNumCols() != b.getNumCols()) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT);
        }
        Matrix result = new Matrix(a.getNumRows(), a.getNumCols());
        for (int i = 0; i < a.getNumRows(); i++) {
            for (int j = 0; j < a.getNumCols(); j++) {
                result.setElement(i, j, a.getElement(i, j) - b.getElement(i, j));
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix a, int scalar) throws MatrixExceptions {
        Matrix result = new Matrix(a.getNumRows(), a.getNumCols());
        for (int i = 0; i < a.getNumRows(); i++) {
            for (int j = 0; j < a.getNumCols(); j++) {
                result.setElement(i, j, a.getElement(i, j) * scalar);
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix a, Matrix b) throws MatrixExceptions {
        if (a.getNumCols() != b.getNumRows()) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_MULTIPLY);
        }
        Matrix result = new Matrix(a.getNumRows(), b.getNumCols());
        for (int i = 0; i < a.getNumRows(); i++) {
            for (int j = 0; j < b.getNumCols(); j++) {
                int sum = 0;
                for (int k = 0; k < a.getNumCols(); k++) {
                    sum += a.getElement(i, k) * b.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }
}