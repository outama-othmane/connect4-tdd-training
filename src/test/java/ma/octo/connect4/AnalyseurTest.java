package ma.octo.connect4;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class AnalyseurTest {
    @Test
    public void givenAGridWithOnlyOneTokenShouldReturnEmpty() {

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleRows()).thenReturn(getInitializedRows());

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);
        Optional<String> expected = Optional.empty();

        assertEquals(expected, result);
    }

    @Test
    public void givenAGridWith4SuccessiveTokensHorizontallyShouldReturnOptionalWithToken() {
        /////
        List<List<String>> rows = getInitializedRows();

        List<String> row = rows.get(5);
        row.set(0, "x");
        row.set(1, "x");
        row.set(2, "x");
        row.set(3, "x");
        /////

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleRows()).thenReturn(rows);

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);

        Optional<String> expected = Optional.of("x");

        assertEquals(expected, result);
    }

    private List<List<String>> getInitializedRows() {
        List<List<String>> mockitoRows = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                rows.add(j, ".");
            }
            mockitoRows.add(i, rows);
        }

        return mockitoRows;
    }
}