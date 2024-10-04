package io.github.nathanjrussell.matrixlib;

public class IdentityMatrix extends SquareMatrix {

    public IdentityMatrix(int size) throws MatrixExceptions {
        super(size);
        for (int i = 0; i < size; i++) {
            data[i][i] = 1;
        }

    }

    // Identity matrix specific behavior can be added here if needed
}
