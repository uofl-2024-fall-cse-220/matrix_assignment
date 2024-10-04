package io.github.nathanjrussell.matrixlib;

public interface MatrixInterface {
    void setEntry(int row, int col, int value) throws MatrixExceptions; //This method will set/update a value in a specific row nad column
    int getEntry(int row, int col) throws  MatrixExceptions; //This method will get the value in a specific row and column

    int getNumRows(); //This method will return the number of rows  in the matrix
    int getNumCols(); //This method will return the number of columns in the matrix

    Matrix add(Matrix other) throws MatrixExceptions; //This method will add two matrices
    Matrix subtract(Matrix other) throws MatrixExceptions; //This method will subtract two matrices
    Matrix multiply(Matrix other) throws MatrixExceptions; //This method will multiply two matrices
    Matrix transpose() throws MatrixExceptions; //This method will return the transpose of the matrix
}
