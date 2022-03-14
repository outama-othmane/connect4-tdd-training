package ma.octo.connect4;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {

    @Test
    public void insertInColumnShouldThrowAnExceptionIfColumnIsGreaterThan7()
    {
        Grille grille = new Grille();
        assertThrows(Exception.class, () -> grille.insertInColumn(8));
    }

    @Test
    public void insertInColumnShouldThrowAnExceptionIfColumnIsLessThan1()
    {
        Grille grille = new Grille();
        assertThrows(Exception.class, () -> grille.insertInColumn(0));
    }
}