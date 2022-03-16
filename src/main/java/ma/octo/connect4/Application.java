package ma.octo.connect4;

public class Application {
    private  GrilleAxes grille;
    private Analyseur analyseur;
    private Vue vue;

    public Application(GrilleAxes grille, Analyseur analyseur, Vue vue) {
        this.analyseur = analyseur;
        this.vue = vue;
        this.grille = grille;
    }

    public void play() {
        vue.write(grille.grilleAsString());
        vue.write("Player1 enter column number [1-7]: ");

        String userInput = vue.read();

        if ("hello".equals(userInput))
            vue.write("Please enter a valid number between [1-7].");

        int userColumn = Integer.parseInt(userInput);

        if (userColumn > 7)
            vue.write("Please enter a valid number between [1-7].");
    }
}
