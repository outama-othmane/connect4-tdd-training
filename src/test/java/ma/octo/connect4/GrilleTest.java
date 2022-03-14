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
        int column = 1, row = 0;
        Grille grille = new Grille();
        grille.insertInColumn(1, "hello");

        assertEquals("hello", grille.getValueOfCoordinates(column, row));
    }
}