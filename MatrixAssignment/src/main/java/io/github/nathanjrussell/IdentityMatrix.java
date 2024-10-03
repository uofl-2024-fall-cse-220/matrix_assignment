package io.github.nathanjrussell;

public class IdentityMatrix extends SquareMatrix {
    public IdentityMatrix(int size) throws MatrixExceptions {
        super(size);
        for (int i = 0; i < size; i++) {
            setElement(i, i, 1);
        }
    }

    public IdentityMatrix power(int n) throws MatrixExceptions {
        if (n < 0) {
            throw new MatrixExceptions(MatrixValidationErrorEnum.INVALID_POWER);
        }

        return new IdentityMatrix(getSize());
    }
}
