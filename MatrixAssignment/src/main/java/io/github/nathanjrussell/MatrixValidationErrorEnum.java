package io.github.nathanjrussell;

public enum MatrixValidationErrorEnum {
    INVALID_NUM_ROWS(700, "Invalid number of rows. Number of rows must be an integer greater than zero."),
    INVALID_NUM_COLS(701, "Invalid number of columns. Number of columns must be an integer greater than zero."),
    INVALID_ROW(702, "Invalid row. Row must be an integer greater than or equal to one and less than or equal to the number of rows."),
    INVALID_COL(703, "Invalid column. Column must be an integer greater than or equal to one and less than or equal to the number of columns."),
    INVALID_VALUE(704, "Invalid value. Value must be an integer.");

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
