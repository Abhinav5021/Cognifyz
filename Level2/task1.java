// Task : Tic-Tac-Toe Game
// Description: Implement a two-player tic-tac-toe
// game. Display the game board and prompt each
// player to enter their moves. Check for a winning
// condition or a draw after each move, and display
// the result accordingly. Allow the players to play
// multiple rounds if desired.

// Skills: Arrays or matrices, loops, conditional
// statements.

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;
        int round = 1;

        while (playAgain) {
            char[][] board = new char[3][3];
            initializeBoard(board);
            char player = 'X';
            boolean gameOver = false;

            while (!gameOver) {
                displayBoard(board);
                System.out.println("Player " + player + ", enter your move (1-9):");
                int move = input.nextInt();
                if (move < 1 || move > 9) {
                    System.out.println("Invalid move, try again.");
                    continue;
                }
                int row = (move - 1) / 3;
                int col = (move - 1) % 3;
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    if (checkWin(board, player)) {
                        displayBoard(board);
                        System.out.println("Player " + player + " wins round " + round);
                        gameOver = true;
                    } else if (checkDraw(board)) {
                        displayBoard(board);
                        System.out.println("Round " + round + " is a draw");
                        gameOver = true;
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
            round++;
            System.out.println("Do you want to play another round? (y/n):");
            String ans = input.next();
            playAgain = ans.equalsIgnoreCase("y");
        }
        System.out.println("Game over");
        input.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public static void displayBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            return true;
        return false;
    }

    public static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}
