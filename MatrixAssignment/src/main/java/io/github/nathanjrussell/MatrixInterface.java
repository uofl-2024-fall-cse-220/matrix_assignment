package io.github.nathanjrussell;

public interface MatrixInterface {
    void setElement(int row, int col, int value); //This method will set/update a value in a specific row nad column
    int getElement(int row, int col); //This method will get the value in a specific row and column
    void doubleEveryEntry(); //This method will double every entry in the matrix
    void addOneToEveryEntry(); //This method will add one to every entry in the matrix
    int getNumRows(); //This method will return the number of rows  in the matrix
    int getNumCols(); //This method will return the number of columns in the matrix
}
