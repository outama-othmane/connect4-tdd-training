package com.octo.connect4;

public class Grid<T> {
    private Integer[][] matrix;

    public Grid() {
        int rows = 6;
        int cols = 7;

        this.matrix = new Integer[6][7];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public Integer[][] getMatrix() {
        return matrix;
    }
}
