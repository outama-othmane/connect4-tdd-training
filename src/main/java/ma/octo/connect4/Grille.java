package ma.octo.connect4;

import java.util.ArrayList;
import java.util.List;

public class Grille {
    private final List<List<String>> tokens;

    public Grille() {
        String defaultValue = ".";

        this.tokens = new ArrayList<>();
        for (int i= 0; i < getColsLength(); i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < getRowsLength(); j++) {
                rows.add(j, defaultValue);
            }

            this.tokens.add(i, rows);
        }

        System.out.println(tokens);
    }

    public void insertInColumn(int column, String value) throws Exception {
        if (column > 6)
            throw new Exception("Column should not be greater than 6");

        if (column < 0)
            throw new Exception("Column should not be less than 0");

        List<String> rowsOfColumn = tokens.get(column);

        int availableRow = -1;
        String defaultValue = ".";

        for (int i = 0; i < getRowsLength(); i++) {
            if (defaultValue.equals(rowsOfColumn.get(i))) {
                availableRow = i;
                break;
            }
        }
        rowsOfColumn.remove(availableRow);
        rowsOfColumn.add(availableRow, value);

        tokens.remove(column);
        tokens.add(column, rowsOfColumn);
    }

    public String getValueOfCoordinates(int column, int row) {
        return tokens.get(column).get(row);
    }

    public int getRowsLength() {
        return 6;
    }

    public int getColsLength() {
        return 7;
    }
}
