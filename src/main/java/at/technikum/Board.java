package at.technikum;

public class Board {
    private char[][] cells;

    public Board(){
        cells = new char[3][3];
    }

    public boolean isCellEmpty(int x, int y){
        if (cells[x][y] == ' ') {
            return true;
        }

        return false;
    }
}
