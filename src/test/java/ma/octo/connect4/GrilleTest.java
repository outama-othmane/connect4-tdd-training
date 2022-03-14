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
    public void insertInColumnShouldInsertHelloInTheLastRowOfFirstColumn() throws Exception {
        Grille grille = new Grille();

        int column = 1;
        int row = grille.getRowsLength() - 1;

        grille.insertInColumn(column, "hello");


        assertEquals("hello", grille.getValueOfCoordinates(column, row));
    }

    @Test
    public void insertInColumnShouldInsertTestInTheBeforeLastRowOfThePreFilledFirstColumn() throws Exception {
        Grille grille = new Grille();

        int column = 1;
        int row = grille.getRowsLength() - 2;

        grille.insertInColumn(column, "hello");
        grille.insertInColumn(column, "test");

        assertEquals("test", grille.getValueOfCoordinates(column, row));
    }
}