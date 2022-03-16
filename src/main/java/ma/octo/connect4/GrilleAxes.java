package ma.octo.connect4;

import java.util.List;

public interface GrilleAxes {
    List<List<String>> getGrilleColumns();
    List<List<String>> getGrilleRows();
    List<List<String>> getGrilleDiagonals();

    String grilleAsString();

    void insertInColumn(int column, String value) throws Exception;
}
