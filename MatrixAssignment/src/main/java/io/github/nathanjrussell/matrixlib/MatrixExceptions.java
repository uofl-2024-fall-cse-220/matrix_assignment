package io.github.nathanjrussell.matrixlib;

public class MatrixExceptions  extends  Exception{
    public MatrixExceptions(MatrixValidationErrorEnum error) {
        super(error.toString());
    }

}
