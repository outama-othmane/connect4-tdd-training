package ma.octo.connect4;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {

    @Test
    public void insertInColumnShouldThrowAnExceptionIfColumnIsGreaterThan6()
    {
        Grille grille = new Grille();
        assertThrows(Exception.class, () -> grille.insertInColumn(7, ""));
    }

    @Test
    public void insertInColumnShouldThrowAnExceptionIfColumnIsLessThan0()
    {
        Grille grille = new Grille();
        assertThrows(Exception.class, () -> grille.insertInColumn(-1, ""));
    }

    @Test
    public void insertInColumnShouldInsertHelloInTheFirstRowOfFirstColumn() throws Exception {
        Grille grille = new Grille();

        int column = 1;
        int row = 0;

        grille.insertInColumn(column, "hello");

        assertEquals("hello", grille.getValueOfCoordinates(column, row));
    }

    @Test
    public void insertInColumnShouldInsertTestInTheSecondRowOfThePreFilledFirstColumn() throws Exception {
        Grille grille = new Grille();

        int column = 1;
        int row = 1;

        grille.insertInColumn(column, "hello");
        grille.insertInColumn(column, "test");

        assertEquals("test", grille.getValueOfCoordinates(column, row));
    }

    @Test
    public void insertInColumnShouldInsertBonjourInTheLastRowOfThePreFilledFirstColumn() throws Exception {
        Grille grille = new Grille();

        int column = 1;
        int row = grille.getRowsLength() - 1;

        for (int i = 0; i < grille.getRowsLength() - 1; i++) {
            grille.insertInColumn(column, "hello");
        }
        grille.insertInColumn(column, "bonjour");

        assertEquals("bonjour", grille.getValueOfCoordinates(column, row));
    }

    @Test
    public void insertInColumnShouldThrowAnExceptionIfTheColumnIsFilled() throws Exception {
        Grille grille = new Grille();
        int column = 6;

        for (int i = 0; i < grille.getRowsLength(); i++) {
            grille.insertInColumn(column, "hello");
        }

        assertThrows(ColumnGrilleException.class, () -> grille.insertInColumn(column, "bonjour"));
    }

    @Test
    public void testGrilleIsEmptyForNewInitializedInstance() {
        Grille grille = new Grille();
        assertTrue(grille.isEmpty());
    }
}