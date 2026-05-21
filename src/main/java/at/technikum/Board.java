package at.technikum;

public class Board {

    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int row, int column) {
        return cells[row][column] == ' ';
    }

    public void place(int row, int column, char marker) {
        cells[row][column] = marker;
    }

    public void clear() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                cells[row][column] = ' ';
            }
        }
    }

    public char[][] getCells() {
        return cells;
    }
}