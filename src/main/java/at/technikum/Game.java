package at.technikum;

public class Game {

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game() {
        startNewGame();
    }

    public void startNewGame() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public boolean makeMove(int row, int column) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return false;
        }

        if (!board.isCellEmpty(row, column)) {
            return false;
        }

        board.place(row, column, currentPlayer.getMarker());

        if (!hasWinner(currentPlayer.getMarker()) && !isDraw()) {
            switchPlayer();
        }

        return true;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == playerX ? playerO : playerX;
    }

    public boolean hasWinner(char marker) {
        char[][] cells = board.getCells();

        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }

            if (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker) {
                return true;
            }
        }

        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }

        return cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker;
    }

    public boolean isDraw() {
        return board.isFull() && !hasWinner('X') && !hasWinner('O');
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}