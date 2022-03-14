package ma.octo.connect4;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {

    @Test
    public void insertInColumnShouldThrowAnExceptionIfXIsGreaterThan7()
    {
        Grille grille = new Grille();
        assertThrows(Exception.class, () -> {
            grille.insertInColumn(8);
        });
    }
}