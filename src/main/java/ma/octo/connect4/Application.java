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
            int chosenColumn = promptUserInput();
            if(chosenColumn < 0) continue;
            boolean isInserted = insertUserInputToGrid(chosenColumn);
            if(!isInserted) continue;
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
        } catch (NumberFormatException ignored) {}

        if (userChosenColumn > 7 || userChosenColumn < 1){
            vue.write("Please enter a valid number between [1-7].");
            return -1;
        }
        return userChosenColumn;

    }

    private boolean insertUserInputToGrid(int userChosenColumn) {
        int column = userChosenColumn - 1;

        try {
            grille.insertInColumn(column, currentPlayer);
            return true;
        }
        catch (ColumnGrilleException ex){
            vue.write("The column is full. Please try again!");
        }
        catch (Exception ignored) {}
        return false;
    }
}
