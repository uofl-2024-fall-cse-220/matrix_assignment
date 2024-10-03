package io.github.nathanjrussell;

public interface SquareMatrixInterface extends MatrixInterface {
    int getSize(); //This method will return the size of the square matrix
    SquareMatrix power(int n) throws MatrixExceptions; //This method will return the square matrix raised to the power of n


}
