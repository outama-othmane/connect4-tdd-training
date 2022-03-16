package ma.octo.connect4;

import java.util.List;
import java.util.Optional;

public class Analyseur {
    public Optional<String> checkForWinner(GrilleAxes grille) throws AnalyseurDrawException {
        Optional<String> winnerFromRows = checkForWinnerForGivenList(grille.getGrilleRows());
        if (winnerFromRows.isPresent()) {
            return winnerFromRows;
        }

        Optional<String> winnerFromColumns = checkForWinnerForGivenList(grille.getGrilleColumns());
        if (winnerFromColumns.isPresent()) {
            return winnerFromColumns;
        }

        Optional<String> winnerFromDiagonals = checkForWinnerForGivenList(grille.getGrilleDiagonals());
        if (winnerFromDiagonals.isPresent()) {
            return winnerFromDiagonals;
        }

        if (checkIfDraw(grille)) {
            throw new AnalyseurDrawException();
        }

        return Optional.empty();

    }

    private boolean checkIfDraw(GrilleAxes grille) {
        return grille.getGrilleRows()
                .stream()
                .flatMap(List::stream)
                .noneMatch(Grille.DEFAULT_INITIALIZATION_VALUE::equals);
    }

    private Optional<String> checkForWinnerForGivenList(List<List<String>> elements) {
        for (List<String> element : elements) {
            String token = element.get(0);
            int counter = 1;

            for (int i = 1; i < element.size(); i++) {
                if (!token.equals(Grille.DEFAULT_INITIALIZATION_VALUE) && token.equals(element.get(i))) {
                    counter++;
                } else {
                    token = element.get(i);
                    counter = 1;
                }

                if (counter >= 4) {
                    return Optional.of(token);
                }
            }
        }

        return Optional.empty();
    }
}
