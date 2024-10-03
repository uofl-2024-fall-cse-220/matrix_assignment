package io.github.nathanjrussell;

public class MatrixExceptions  extends  Exception{
    public MatrixExceptions(MatrixValidationErrorEnum error) {
        super(error.toString());
    }

}
