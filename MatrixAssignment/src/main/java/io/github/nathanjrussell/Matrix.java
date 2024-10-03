package io.github.nathanjrussell;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Matrix implements MatrixInterface {
    private int[][] matrix;
    private int numCols;
    private int numRows;
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
    public void setElement(int row, int col, int value) {
        matrix[row][col] = value;
    }
    public int getElement(int row, int col) {
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
}