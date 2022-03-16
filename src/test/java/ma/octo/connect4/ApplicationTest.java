package ma.octo.connect4;

import org.junit.Test;
import org.mockito.Mockito;

public class ApplicationTest {

    @Test
    public void playShouldCallWriteVue() {
        GrilleAxes grille = Mockito.mock(GrilleAxes.class);
        Mockito.when(grille.grilleAsString()).thenReturn(". . .");

        Analyseur analyseur = new Analyseur();

        Vue vue = Mockito.mock(Vue.class);

        Application application = new Application(grille, analyseur, vue);
        application.play();

        Mockito.verify(vue).write(grille.grilleAsString());
    }

}