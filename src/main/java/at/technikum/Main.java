package at.technikum;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


        public static void main(String[] args) {

            Board board = new Board();

            board.place(1, 1, 'X');
            board.place(0, 0, 'O');

            board.print();
        }
    }
