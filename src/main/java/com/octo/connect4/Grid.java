package com.octo.connect4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Grid {
    private List<List<String>> matrix;

    public Grid() {
        initializer(".");
    }

    private void initializer(String initString) {
        int rows = 6;
        int cols = 7;

        matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<String> rowI = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                rowI.add(j, initString);
            }
            matrix.add(i, rowI);
        }
    }

    public int getColsLength() {
        return 7;
    }

    public int getRowsLength() {
        return 6;
    }

    public void insertForX(int x, String value) throws Exception {
        if (x > 7)
            throw new Exception("X should not be greater than 7!");

        if (x < 1)
            throw new Exception("X should not be less than 1!");
    }

    public Collection<String> getAllValues() {
        Collection<String> values = new ArrayList<>();
        matrix.forEach(values::addAll);

        return values;
    }
}
