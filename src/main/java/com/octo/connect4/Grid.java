package com.octo.connect4;

import java.util.List;

public class Grid {
    private List<List<String>> matrix;

    public Grid() {
        int rows = 6;
        int cols = 7;
        //
    }


    public int getColsLength() {
        return 7;
    }

    public int getRowsLength() {
        return 6;
    }

    public void insertForX(int x, String hello) throws Exception {
        if (x > 7)
            throw new Exception("X should not be greater than 7!");

        if (x < 1)
            throw new Exception("X should not be less than 1!");
    }
}
