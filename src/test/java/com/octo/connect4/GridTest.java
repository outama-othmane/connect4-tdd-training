package com.octo.connect4;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void checkIfTheMatrixDimensionIs6x7() {
        Grid<Integer> grid = new Grid<>();

        Integer[][] matrix = grid.getMatrix();

        Assert.assertEquals(6, matrix.length);
        Assert.assertEquals(7, matrix[0].length);
    }

}
