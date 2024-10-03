package io.github.nathanjrussell;

public enum MatrixValidationErrorEnum {
    INVALID_NUM_ROWS(700, "Invalid number of rows. Number of rows must be an integer greater than zero."),
    INVALID_NUM_COLS(701, "Invalid number of columns. Number of columns must be an integer greater than zero."),
    INVALID_ROW(702, "Invalid row. Row must be an integer greater than or equal to zero and less than the number of rows."),
    INVALID_COL(703, "Invalid column. Column must be an integer greater than or equal to zero and less than the number of columns."),
    INVALID_VALUE(704, "Invalid value. Value must be an integer."),

    INCOMPATIBLE_MATRIX_DIMENSIONS_MULTIPLY(706, "Incompatible matrix dimensions. The number of columns in the first matrix must equal the number of rows in the second matrix."),
    INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT(706, "Incompatible matrix dimensions. The dimensions of the two matrices must be the same."),

    //Below are errors associated with SquareMatrix
    INVALID_SQUARE_MATRIX_SIZE(705, "Invalid dimensions. The number of rows must equal the number of columns."),
    INVALID_POWER(707, "Invalid power. The power must be an integer greater than or equal to zero.");

    private final int code;
    private final String message;

    MatrixValidationErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return code + ": " + message;
    }
}
