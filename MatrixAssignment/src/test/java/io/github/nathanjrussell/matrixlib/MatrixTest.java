package io.github.nathanjrussell.matrixlib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MatrixTest {

    @Test
    public void testMatrixConstructor() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        assertEquals(3, matrix.getNumRows());
        assertEquals(3, matrix.getNumCols());
    }

    @Test
    public void testMatrixConstructorWithInvalidNumRows() {
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new Matrix(0, 3));
        assertEquals(MatrixValidationErrorEnum.INVALID_NUM_ROWS.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixConstructorWithInvalidNumCols() {
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new Matrix(3, 0));
        assertEquals(MatrixValidationErrorEnum.INVALID_NUM_COLS.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixConstructorWithData() throws MatrixExceptions {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix matrix = new Matrix(data);
        assertEquals(3, matrix.getNumRows());
        assertEquals(3, matrix.getNumCols());
        assertEquals(1, matrix.getEntry(0, 0));
        assertEquals(5, matrix.getEntry(1, 1));
        assertEquals(9, matrix.getEntry(2, 2));
    }

    @Test
    public void testMatrixConstructorWithInvalidData() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new Matrix(data));
        assertEquals(MatrixValidationErrorEnum.INVALID_NUM_COLS.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidRow1() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(-4, 1));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidRow2() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(30, 4));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidRow3() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(31, 4));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidCol1() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(1, -4));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidCol2() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(4, 12));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixGetEntryWithInvalidCol3() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(4, 13));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

}
