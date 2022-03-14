package ma.octo.connect4;

import java.util.ArrayList;
import java.util.List;

public class Grille {
    public final static String DEFAULT_INITIALIZATION_VALUE = ".";

    private final List<List<String>> tokens;

    public Grille() {
        this.tokens = new ArrayList<>();
        for (int i= 0; i < getColsLength(); i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < getRowsLength(); j++) {
                rows.add(j, DEFAULT_INITIALIZATION_VALUE);
            }
            this.tokens.add(i, rows);
        }
    }

    public void insertInColumn(int column, String value) throws Exception {
        if (column > 6)
            throw new Exception("Column should not be greater than 6");

        if (column < 0)
            throw new Exception("Column should not be less than 0");

        List<String> rowsOfColumn = tokens.get(column);
        int availableRow = getAvailableRow(column, rowsOfColumn);

        rowsOfColumn.remove(availableRow);
        rowsOfColumn.add(availableRow, value);

        tokens.remove(column);
        tokens.add(column, rowsOfColumn);
    }

    private int getAvailableRow(int column, List<String> rowsOfColumn) throws ColumnGrilleException {
        int availableRow = -1;
        for (int i = 0; i < getRowsLength(); i++) {
            if (DEFAULT_INITIALIZATION_VALUE.equals(rowsOfColumn.get(i))) {
                availableRow = i;
                break;
            }
        }

        if (availableRow == -1) {
            throw new ColumnGrilleException(String.format("The %s is already filled", column));
        }

        return availableRow;
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

    public boolean isEmpty() {
        return tokens.stream()
            .flatMap(List::stream)
            .allMatch(DEFAULT_INITIALIZATION_VALUE::equals);
    }
}
