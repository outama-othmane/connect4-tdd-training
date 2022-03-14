package ma.octo.connect4;

import java.util.List;

public class Grille {
    private List<List<String>> tokens;

    public void insertInColumn(int column) throws Exception {
        if (column > 7)
            throw new Exception("Column should not be greater than 7!");
    }
}
