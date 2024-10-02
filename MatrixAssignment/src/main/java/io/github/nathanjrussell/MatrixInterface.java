package io.github.nathanjrussell;

public interface MatrixInterface {
    void setElement(int row, int col, int value);
    int getElement(int row, int col);
    void doubleEveryEntry();
    void addOneToEveryEntry();
    int getNumRows();
    int getNumCols();
}
