package ma.octo.connect4;

import java.util.List;

public class Grille {
    private List<List<String>> tokens;

    public void insertInColumn(int column, String value) throws Exception {
        if (column > 6)
            throw new Exception("Column should not be greater than 6");

        if (column < 0)
            throw new Exception("Column should not be less than 0");
    }

    public String getValueOfCoordinates(int column, int row) {
        return "hello";
    }

    public int getRowsLength() {
        return 6;
    }
}
