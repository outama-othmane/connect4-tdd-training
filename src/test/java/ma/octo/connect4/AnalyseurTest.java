package ma.octo.connect4;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnalyseurTest {
    @Test
    public void givenAGridWithOnlyOneTokenShouldReturnEmpty() throws AnalyseurDrawException {

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleRows()).thenReturn(getInitializedListOfListString(6, 7));

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);
        Optional<String> expected = Optional.empty();

        assertEquals(expected, result);
    }

    @Test
    public void givenAGridWith4SuccessiveTokensHorizontallyShouldReturnOptionalWithToken() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleRows())
            .thenReturn(getRowsWith4SuccessiveXInTheSixthRow());

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);

        Optional<String> expected = Optional.of("x");

        assertEquals(expected, result);
    }

    @Test
    public void givenAGridWith4SuccessiveTokensVerticallyShouldReturnOptionalWithToken() throws AnalyseurDrawException {

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleColumns()).thenReturn(getColumnsWith4SuccessiveOInTheSeventhColumn());

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);

        Optional<String> expected = Optional.of("o");

        assertEquals(expected, result);
    }

    @Test
    public void givenAGridWith4SuccessiveTokensDiagonallyShouldReturnOptionalWithToken() throws AnalyseurDrawException {

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleDiagonals()).thenReturn(getDiagonalsWith4SuccessiveX());

        Analyseur analyseur = new Analyseur();
        Optional<String> result = analyseur.checkForWinner(grille);

        Optional<String> expected = Optional.of("x");

        assertEquals(expected, result);
    }

    @Test
    public void givenAFullGridWithNoWinnerShouldThrowException() {

        List<List<String>> list = new ArrayList<>();
        list.add(List.of("o", "x", "o", "x"));
        list.add(List.of("x", "x", "o", "x"));
        list.add(List.of("o", "o", "o", "x"));
        list.add(List.of("o", "o", "o", "x"));

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.getGrilleRows()).thenReturn(list);

        Analyseur analyseur = new Analyseur();
        assertThrows(AnalyseurDrawException.class, () -> analyseur.checkForWinner(grille));
    }

    private List<List<String>> getDiagonalsWith4SuccessiveX() {
        List<List<String>> diagonals = new ArrayList<>();
        diagonals.add(List.of(Grille.DEFAULT_INITIALIZATION_VALUE));
        diagonals.add(List.of(Grille.DEFAULT_INITIALIZATION_VALUE, "x"));
        diagonals.add(List.of(Grille.DEFAULT_INITIALIZATION_VALUE, "x", "x"));
        diagonals.add(List.of("x", "x", "x", "x"));

        return diagonals;
    }

    private List<List<String>> getColumnsWith4SuccessiveOInTheSeventhColumn() {
        List<List<String>> columns = getInitializedListOfListString(7, 6);

        List<String> column = columns.get(6);
        column.set(1, "o");
        column.set(2, "o");
        column.set(3, "o");
        column.set(4, "o");
        return columns;
    }

    private List<List<String>> getRowsWith4SuccessiveXInTheSixthRow() {
        List<List<String>> rows = getInitializedListOfListString(6, 7);

        List<String> row = rows.get(5);
        row.set(0, "x");
        row.set(1, "x");
        row.set(2, "x");
        row.set(3, "x");
        return rows;
    }

    private List<List<String>> getInitializedListOfListString(int firstListLength, int secondListLength) {
        List<List<String>> mockitoRows = new ArrayList<>();
        for (int i = 0; i < firstListLength; i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < secondListLength; j++) {
                rows.add(j, Grille.DEFAULT_INITIALIZATION_VALUE);
            }
            mockitoRows.add(i, rows);
        }

        return mockitoRows;
    }
}