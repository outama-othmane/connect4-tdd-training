package ma.octo.connect4;

import java.util.Optional;

public class Application {
    public final static String PLAYER_1 = "Player1";
    public final static String PLAYER_2 = "Player2";

    private  GrilleAxes grille;
    private Analyseur analyseur;
    private Vue vue;
    private String currentPlayer = PLAYER_1;


    public Application(GrilleAxes grille, Analyseur analyseur, Vue vue) {
        this.analyseur = analyseur;
        this.vue = vue;
        this.grille = grille;
    }

    public void play() {
        Optional<String> winner = Optional.empty();
        do {
            vue.write(grille.grilleAsString());
            vue.write(String.format("%s enter column number [1-7]: ", currentPlayer));
            promptUserInput();

            try {
                winner = analyseur.checkForWinner(grille);
                if (winner.isPresent()) {
                    vue.write(String.format("%s is the winner!", currentPlayer));
                }
            } catch (AnalyseurDrawException ignored) {}

            currentPlayer = PLAYER_1.equals(currentPlayer) ? PLAYER_2 : PLAYER_1;
        } while (winner.isEmpty());
    }

    private int promptUserInput() {
        String userInput = vue.read();
        int userChosenColumn = -1;

        try {
            userChosenColumn = Integer.parseInt(userInput);
        } catch (NumberFormatException ignored) {

        }

        if (userChosenColumn > 7)
            vue.write("Please enter a valid number between [1-7].");

        if (userChosenColumn < 1)
            vue.write("Please enter a valid number between [1-7].");

        insertUserInputToGrid(userChosenColumn);

        return userChosenColumn;
    }

    private void insertUserInputToGrid(int userChosenColumn) {
        String player = "o";
        int column = userChosenColumn - 1;

        try {
            grille.insertInColumn(column, player);
        } catch (Exception ignored) {

        }
    }
}
