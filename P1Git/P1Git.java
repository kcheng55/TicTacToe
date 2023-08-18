package kcheng5_p1;

import java.util.Scanner;
/**
 * This program simulates a tictactoe game between 2 players. The program checks
 * for the winner every round. And displays a game stats in the end.
 *
 * @author Kang Cheng
 * @version 1.0
 */
public class P1git {
    /**
     * The main function asks the user for board location, creates the board
     * array, and repeat the game.
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {

        final int SIZE = 3; //size of the array
        char repeat;

        Scanner keyboard = new Scanner(System.in);

        welcome();  // print welcome message
        do {
            printInitial(SIZE); // print the starting of the board

            TicTacToe game = new TicTacToe(SIZE);   // create 'game' object

            // to repeat the whole program
            int[][] arr = new int[SIZE][SIZE];  // create 0 board array
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++)
                    arr[i][j] = 0;
            }

            int row, col, count = 0; // holds user input and count

            do {    // loop for checking winner
                // loops between 2 players
                if (count % 2 == 0)
                    System.out.print("O is your turn:");
                else
                    System.out.print("X is your turn:");

                System.out.print("\nWhich row?")
                row = keyboard.nextInt();
                System.out.print("Which column?");
                col = keyboard.nextInt();
                // validate user input
                if (row > SIZE -1 || col > SIZE -1) {
                    System.out.print("Bad location, try again...\n");
                    game.printUpdated(arr); // print the previous board
                    System.out.print("Which row?"); // ask for another input
                    row = keyboard.nextInt();
                    System.out.print("Which column?");
                    col = keyboard.nextInt();
                }
                count++;    // increments count
            } while (game.updateBoard(arr, row, col, count));

            statsDisplay(count, SIZE);  // display winner

            System.out.print("\nDo you want to play again? (no to stop)");
            keyboard.nextLine();
            repeat = keyboard.nextLine().charAt(0);
        } while (repeat == 'y' || repeat =='Y');
        keyboard.close();   // close scanner
    }

    /**
     * This method is to display game winner
     * @param count The number of rounds that played
     * @param SIZE The board size
     */
        public static void statsDisplay(int count, int SIZE) {
            int xWon = 0, oWon = 0, tie = 0;
            if (count == SIZE * SIZE) {
                System.out.print("No winner - it was a tie!");
                tie++;
            }
            else if (count % 2 == 0) {
                System.out.print("X you win!\n");
                oWon++;
            }
            else {
                System.out.print("O you win!\n");
                xWon++;
            }

            System.out.println("\nGame Stats\n" +
                    "X has won " + xWon + " games.\n" +
                    "O has won " + oWon + " games.\n" +
                    "There have been " + tie +" tie games.");
        }
    /**
     * Displays welcome message
     */
        public static void welcome() {

            System.out.println("Welcome to TicTacToe! The game plays between" +
                    " 2 players\nof X and O. Each player takes turn to" +
                    "place on the board.\nWhoever has the same in a row" +
                    ", a column or diagonally wins the game.\nLet's start!\n");
        }

    /**
     * Displays initial empty board.
     * @param SIZE The board size.
     */
    public static void printInitial(int SIZE) {
        //// col number display
        for (int k = 0; k < SIZE; k++)
           System.out.printf("%3d", k);
        System.out.print("\n");

        for (int i = 0 ; i < SIZE; i++) {
            System.out.printf("%d",i);  // row number display
           for (int j = 0; j < SIZE; j++)
               System.out.printf("%s", "  |");
           System.out.print("\n");
           System.out.print("----------");
           System.out.print("\n");
        }
    }
}