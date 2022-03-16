package ma.octo.connect4;

import java.util.List;
import java.util.Optional;

public class Analyseur {
    public Optional<String> checkForWinner(GrilleAxes grille) {
        List<List<String>> rows = grille.getGrilleRows();

        for (List<String> row : rows) {
            String token = row.get(0);
            int counter = 1;

            for (int i = 1; i < row.size(); i++) {
                if (counter >= 4) {
                    return Optional.of(token);
                }

                if (!token.equals(Grille.DEFAULT_INITIALIZATION_VALUE) && token.equals(row.get(i))) {
                    counter++;
                } else {
                    token = row.get(i);
                    counter = 1;
                }
            }
        }

        List<List<String>> columns = grille.getGrilleColumns();

        for (List<String> column : columns) {
            String token = column.get(0);
            int counter = 1;

            for (int i = 1; i < column.size(); i++) {
                if (counter >= 4) {
                    return Optional.of(token);
                }

                if (!token.equals(Grille.DEFAULT_INITIALIZATION_VALUE) && token.equals(column.get(i))) {
                    counter++;
                } else {
                    token = column.get(i);
                    counter = 1;
                }
            }
        }



        return Optional.empty();
    }
}
