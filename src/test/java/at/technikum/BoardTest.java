package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void cellIsEmptyAfterBoardCreation() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void cellIsNotEmptyAfterPlacingMarker() {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void placeStoresMarkerX() {
        Board board = new Board();

        board.place(1, 1, 'X');

        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    void placeStoresMarkerO() {
        Board board = new Board();

        board.place(2, 2, 'O');

        assertEquals('O', board.getCells()[2][2]);
    }

    @Test
    void clearRemovesMarker() {
        Board board = new Board();

        board.place(1, 1, 'X');
        board.clear();

        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void clearEmptiesMultipleCells() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(2, 2, 'O');
        board.clear();

        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    void emptyBoardIsNotFull() {
        Board board = new Board();

        assertFalse(board.isFull());
    }

    @Test
    void completelyFilledBoardIsFull() {
        Board board = new Board();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board.place(row, column, 'X');
            }
        }

        assertTrue(board.isFull());
    }

    @Test
    void getCellsReturnsThreeRows() {
        Board board = new Board();

        assertEquals(3, board.getCells().length);
    }

    @Test
    void getCellsContainsPlacedMarker() {
        Board board = new Board();

        board.place(1, 1, 'X');

        assertEquals('X', board.getCells()[1][1]);
    }

}