package com.octo.connect4;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void getMatrixCheckIfTheMatrixDimensionIs6x7() {
        Grid<Integer> grid = new Grid<>();

        Integer[][] matrix = grid.getMatrix();

        Assert.assertEquals(6, matrix.length);
        Assert.assertEquals(7, matrix[0].length);
    }

    @Test
    public void getMatrixCheckIfMatrixInitializedWith0s() {
        Grid<Integer> grid = new Grid<>();

        Integer[][] expected = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
        Integer[][] matrix = grid.getMatrix();

        Assert.assertEquals(expected, matrix);
    }

    @Test
    public void insertForXItShouldThrowAnExceptionIfXIsGreaterThan7() {
        Grid<Integer> grid = new Grid<>();

        Assert.assertThrows(Exception.class, () -> {
            grid.insertForX(8);
        });
    }


}
