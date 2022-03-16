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

        Mockito.verify(vue, Mockito.times(2)).write(grille.grilleAsString());
    }

    @Test
    public void playShouldPrintCurrentPlayerMessageAfterInit() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

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

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEntersHello() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);
        Mockito.when(vue.read()).thenReturn("hello");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEnters8() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);
        Mockito.when(vue.read()).thenReturn("8");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEnters0() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);
        Mockito.when(vue.read()).thenReturn("0");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldInsertThePlayerTokenToTheGivenColumnInTheGrid() throws Exception {
        int chosenColumn = 4;

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);
        Mockito.when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(grille).insertInColumn(chosenColumn, "o");
    }

    @Test
    public void playShouldPrintAgainTheGridAfterFirstPlayerTurn() {
        int chosenColumn = 4;
        String firstGrid = ". . .";
        String secondGrid = "SECOND TIME";

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(firstGrid).thenReturn(secondGrid);

        Analyseur analyseur = new Analyseur();
        Vue vue = Mockito.mock(Vue.class);
        Mockito.when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(firstGrid);
        Mockito.verify(vue).write(secondGrid);
    }


}