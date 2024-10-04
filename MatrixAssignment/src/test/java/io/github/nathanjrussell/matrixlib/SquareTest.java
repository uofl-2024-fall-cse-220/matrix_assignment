package io.github.nathanjrussell.matrixlib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {

    @Test
    public void testSquareMatrixConstructor() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(52);
        assertEquals(52, matrix.getNumRows());
        assertEquals(52, matrix.getNumCols());
    }

    @Test
    public void testSquareMatrixConstructorWithInvalidSize() {
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new SquareMatrix(0));
        assertEquals(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixConstructorWithInvalidSize2() {
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new SquareMatrix(-4));
        assertEquals(MatrixValidationErrorEnum.INVALID_SQUARE_MATRIX_SIZE.toString(), exception.getMessage());
    }


    @Test
    public void testSquareMatrixConstructorWithData() throws MatrixExceptions {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SquareMatrix matrix = new SquareMatrix(data);
        assertEquals(3, matrix.getNumRows());
        assertEquals(3, matrix.getNumCols());
        assertEquals(1, matrix.getEntry(0, 0));
        assertEquals(5, matrix.getEntry(1, 1));
        assertEquals(9, matrix.getEntry(2, 2));
    }

    @Test
    public void testSquareMatrixConstructorWithInvalidData() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> new SquareMatrix(data));
        assertEquals(MatrixValidationErrorEnum.NOT_ALL_ROWS_SAME_LENGTH.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidRow1() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(-4, 1));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidRow2() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(30);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(30, 4));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidRow3() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(30);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(31, 4));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidCol1() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(1, -4));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidCol2() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(4, 12));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixGetEntryWithInvalidCol3() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.getEntry(4, 13));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidRow1() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(-4, 1, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidRow2() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(30);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(30, 4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidRow3() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(30);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(31, 4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_ROW.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidCol1() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(3);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(1, -4, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidCol2() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(4, 12, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntryWithInvalidCol3() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(12);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix.setEntry(4, 13, 5));
        assertEquals(MatrixValidationErrorEnum.INVALID_COL.toString(), exception.getMessage());
    }

    @Test
    public void testSquareMatrixSetEntry() throws MatrixExceptions {
        SquareMatrix matrix = new SquareMatrix(3);
        matrix.setEntry(1, 1, 5);
        assertEquals(5, matrix.getEntry(1, 1));
    }

    @Test
    public void testSquareMatrixAdd() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        SquareMatrix matrix1 = new SquareMatrix(data1);
        SquareMatrix matrix2 = new SquareMatrix(data2);
        SquareMatrix result = matrix1.add(matrix2);
        assertEquals(10, result.getEntry(0, 0));
        assertEquals(10, result.getEntry(1, 1));
        assertEquals(10, result.getEntry(2, 2));
    }



    @Test
    public void testSquareMatrixSubtract() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        SquareMatrix matrix1 = new SquareMatrix(data1);
        SquareMatrix matrix2 = new SquareMatrix(data2);
        SquareMatrix result = matrix1.subtract(matrix2);
        assertEquals(-8, result.getEntry(0, 0));
        assertEquals(0, result.getEntry(1, 1));
        assertEquals(8, result.getEntry(2, 2));
    }

    @Test
    public void testSquareMatrixSubtractWithIncompatibleDimensions() throws MatrixExceptions {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8}, {6, 5}};
        SquareMatrix matrix1 = new SquareMatrix(data1);
        SquareMatrix matrix2 = new SquareMatrix(data2);
        MatrixExceptions exception = assertThrows(MatrixExceptions.class, () -> matrix1.subtract(matrix2));
        assertEquals(MatrixValidationErrorEnum.INCOMPATIBLE_MATRIX_DIMENSIONS_ADD_SUBTRACT.toString(), exception.getMessage());
    }



    @Test
    public void testSquareMatrixPower() throws MatrixExceptions {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SquareMatrix matrix = new SquareMatrix(data);
        SquareMatrix result = matrix.power(2);
        assertEquals(30, result.getEntry(0, 0));
        assertEquals(36, result.getEntry(0, 1));
        assertEquals(42, result.getEntry(0, 2));
        assertEquals(66, result.getEntry(1, 0));
        assertEquals(81, result.getEntry(1, 1));
        assertEquals(96, result.getEntry(1, 2));
        assertEquals(102, result.getEntry(2, 0));
        assertEquals(126, result.getEntry(2, 1));
        assertEquals(150, result.getEntry(2, 2));
    }

}