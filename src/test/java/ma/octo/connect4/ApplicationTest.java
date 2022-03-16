package ma.octo.connect4;

import org.junit.Test;
import org.mockito.Mockito;

public class ApplicationTest {

    @Test
    public void playShouldCallWriteVueAndPrintInitialGrid() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();

        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(grille.grilleAsString());
    }

    @Test
    public void playShouldPrintCurrentPlayerMessageAfterInit() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue, Mockito.times(2)).write(Mockito.anyString());
        Mockito.verify(vue).write("Player1 enter column number [1-7]: ");
    }

    @Test
    public void playShouldReadTheUserChosenColumn() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).read();
    }

}