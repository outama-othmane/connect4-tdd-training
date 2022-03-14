package com.octo.connect4;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    @Test
    public void testIfMatrixDimensionIs6x7() {
        Grid grid = new Grid();

        Assert.assertEquals(7, grid.getColsLength());
        Assert.assertEquals(6, grid.getRowsLength());
    }

    @Test
    public void testItShouldThrowAnExceptionIfXIsGreaterThan7() {
        Grid grid = new Grid();

        Assert.assertThrows(Exception.class, () -> {
            grid.insertForX(8, "hello");
        });
    }

    @Test
    public void testItShouldThrowAnExceptionIfXIsLessThan1() {
        Grid grid = new Grid();

        Assert.assertThrows(Exception.class, () -> {
            grid.insertForX(0, "hello");
        });
    }

    @Test
    public void testNewInstanceOfGridShouldBeEmpty() {
        Grid grid = new Grid();

        Assert.assertTrue(grid.isEmpty());
    }

    @Test
    public void testNewInstanceOfGridWithOneInsertedElementIsNotEmpty() throws Exception {
        Grid grid = new Grid();
        grid.insertForX(1, "test");

        Assert.assertFalse(grid.isEmpty());
    }

    @Test
    public void testGivenAnEmptyColumnsShouldInsertValueHelloInTheLastRowOfXColumn() throws Exception {
        Grid grid = new Grid();
        grid.insertForX(1, "hello");

        Assert.assertEquals("hello", grid.getValueOfCoordinates(1, grid.getRowsLength()));
    }
}
