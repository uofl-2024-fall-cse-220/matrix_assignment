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
        assertEquals(MatrixValidationErrorEnum.NOT_ALL_ROWS_SAME_LENGTH.toString(), exception.getMessage());
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

    @Test
    public void testMatrixSetEntryWithInvalidRow1() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(-4, 1, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntryWithInvalidRow2() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(30, 4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntryWithInvalidRow3() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(31, 4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntryWithInvalidCol1() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(1, -4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntryWithInvalidCol2() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(4, 12, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntryWithInvalidCol3() throws MatrixExceptions {
        Matrix matrix = new Matrix(30, 12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(4, 13, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSetEntry() throws MatrixExceptions {
        Matrix matrix = new Matrix(3, 3);
        matrix.setEntry(1, 1, 5);
        assertEquals(5, matrix.getEntry(1, 1));
    }

    @Test
    public void testMatrixAdd() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.add(matrix2);
        assertEquals(10, result.getEntry(0, 0));
        assertEquals(10, result.getEntry(1, 1));
        assertEquals(10, result.getEntry(2, 2));
    }

    @Test
    public void testMatrixAddWithIncompatibleDimensions() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix1.add(matrix2));
        assertEquals(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixSubtract() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.subtract(matrix2);
        assertEquals(-8, result.getEntry(0, 0));
        assertEquals(0, result.getEntry(1, 1));
        assertEquals(8, result.getEntry(2, 2));
    }

    @Test
    public void testMatrixSubtractWithIncompatibleDimensions() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix1.subtract(matrix2));
        assertEquals(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT.toString(), exception.getMessage());
    }

    @Test
    public void testMatrixMultiply() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{7, 8}, {9, 10}, {11, 12}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.multiply(matrix2);
        assertEquals(58, result.getEntry(0, 0));
        assertEquals(64, result.getEntry(0, 1));
        assertEquals(139, result.getEntry(1, 0));
        assertEquals(154, result.getEntry(1, 1));
    }

    @Test
    public void testMatrixMultiplyWithIncompatibleDimensions() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{7, 8}, {9, 10}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix1.multiply(matrix2));
        assertEquals(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_MULTIPLY.toString(), exception.getMessage());
    }

}
