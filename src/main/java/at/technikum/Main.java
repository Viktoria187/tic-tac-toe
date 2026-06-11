package at.technikum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        boolean playAgain = true;

        while (playAgain) {
            boolean gameOver = false;

            while (!gameOver) {
                System.out.println("Current Player: " + game.getCurrentPlayer().getMarker());
                game.getBoard().print();

                System.out.print("row (0-2): ");
                int row = scanner.nextInt();

                System.out.print("column (0-2): ");
                int column = scanner.nextInt();

                char marker = game.getCurrentPlayer().getMarker();
                boolean validMove = game.makeMove(row, column);

                if (!validMove) {
                    System.out.println("Invalid move!");
                    continue;
                }

                if (game.hasWinner(marker)) {
                    game.getBoard().print();
                    System.out.println("Player " + marker + " wins!");
                    gameOver = true;
                } else if (game.isDraw()) {
                    game.getBoard().print();
                    System.out.println("Draw!");
                    gameOver = true;
                }
            }

            System.out.print("Start new game? (y/n): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("y")) {
                game.startNewGame();
            } else {
                playAgain = false;
            }
        }

        System.out.println("Goodbye!");
    }
}