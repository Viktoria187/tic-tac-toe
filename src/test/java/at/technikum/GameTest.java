package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void newGameStartsWithPlayerX() {
        Game game = new Game();

        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    void startNewGameClearsBoard() {
        Game game = new Game();

        game.makeMove(0, 0);
        game.startNewGame();

        assertTrue(game.getBoard().isCellEmpty(0, 0));
    }

    @Test
    void makeMovePlacesMarkerX() {
        Game game = new Game();

        game.makeMove(0, 0);

        assertEquals('X', game.getBoard().getCells()[0][0]);
    }

    @Test
    void makeMoveReturnsFalseForOccupiedCell() {
        Game game = new Game();

        game.makeMove(0, 0);
        boolean result = game.makeMove(0, 0);

        assertFalse(result);
    }

    @Test
    void makeMoveReturnsFalseForInvalidRow() {
        Game game = new Game();

        boolean result = game.makeMove(3, 0);

        assertFalse(result);
    }

    @Test
    void switchPlayerChangesXToO() {
        Game game = new Game();

        game.switchPlayer();

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    void hasWinnerReturnsTrueForRow() {
        Game game = new Game();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner('X'));
    }

    @Test
    void hasWinnerReturnsFalseForEmptyBoard() {
        Game game = new Game();

        assertFalse(game.hasWinner('X'));
    }

    @Test
    void isDrawReturnsTrueWhenBoardIsFullAndNoWinner() {
        Game game = new Game();

        char[][] cells = game.getBoard().getCells();

        cells[0][0] = 'X';
        cells[0][1] = 'O';
        cells[0][2] = 'X';
        cells[1][0] = 'X';
        cells[1][1] = 'O';
        cells[1][2] = 'O';
        cells[2][0] = 'O';
        cells[2][1] = 'X';
        cells[2][2] = 'X';

        assertTrue(game.isDraw());
    }

    @Test
    void isDrawReturnsFalseForEmptyBoard() {
        Game game = new Game();

        assertFalse(game.isDraw());
    }
}