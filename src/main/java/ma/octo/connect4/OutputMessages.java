package ma.octo.connect4;

public enum OutputMessages {
    DRAW("Game Over! It's a draw!"),
    WIN("%s is the winner!"),
    PROMPT("%s enter column number [%d-%d]: "),
    VALID("Please enter a valid number between [%d-%d]."),
    FULL_COLUMN("The column is full. Please try again!");

    private final String message;

    OutputMessages(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}
