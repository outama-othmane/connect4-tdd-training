package ma.octo.connect4;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ApplicationTest {
    @Test
    public void playShouldCallWriteVueAndPrintInitialGrid() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(grille.grilleAsString());
    }

    @Test
    public void playShouldPrintCurrentPlayerMessageAfterInit() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Player1 enter column number [1-7]: ");
    }

    @Test
    public void playShouldReadTheUserChosenColumn() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).read();
    }

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEntersHello() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn("hello");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEnters8() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn("8");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldPrintTryAgainMessageIfTheUserEnters0() throws AnalyseurDrawException {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn("0");

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Please enter a valid number between [1-7].");
    }

    @Test
    public void playShouldInsertThePlayerTokenToTheGivenColumnInTheGrid() throws Exception {
        int chosenColumn = 4;

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(grille).insertInColumn(chosenColumn, "o");
    }

    @Test
    public void playShouldPrintAgainTheGridAfterFirstPlayerTurn() throws AnalyseurDrawException {
        int chosenColumn = 4;
        String firstGrid = ". . .";
        String secondGrid = "SECOND TIME";

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(firstGrid).thenReturn(secondGrid);

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.empty()).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(firstGrid);
        Mockito.verify(vue).write(secondGrid);
    }

    @Test
    public void playShouldPrintPlayer2MessageAfterPlayer1Round() throws AnalyseurDrawException {
        int chosenColumn = 4;

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.empty()).thenReturn(Optional.of("String"));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("Player2 enter column number [1-7]: ");
    }

    @Test
    public void playShouldPrintTheWinnerMessage() throws AnalyseurDrawException {
        int chosenColumn = 4;

        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of(Application.PLAYER_1));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn(String.valueOf(chosenColumn + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(String.format("%s is the winner!", Application.PLAYER_1));
    }

    @Test
    public void shouldPrintChoseANoneFullColumnMessageIfTheUserTriesToInsertToAFullColumnOfTheGrid() throws Exception {

        int fullColumnNumber = 0;
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        when(grille.grilleAsString()).thenReturn(". . .");
        doThrow(ColumnGrilleException.class).when(grille)
                .insertInColumn(eq(fullColumnNumber), anyString());

        Analyseur analyseur = Mockito.mock(Analyseur.class);
        when(analyseur.checkForWinner(grille)).thenReturn(Optional.of("."));

        Vue vue = Mockito.mock(Vue.class);
        when(vue.read()).thenReturn(String.valueOf(fullColumnNumber + 1));

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write("The column is full. Please try again!");
    }

}