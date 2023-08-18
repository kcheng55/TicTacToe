package kcheng5_p1;

/**
 * This class contains updating, checking and displaying of the
 * board array everytime when user plays.
 */
public class TicTacToe {

    private final int SIZE; // size of the array

    public TicTacToe(int SIZE) {
        this.SIZE = SIZE;
    }

    /**
     * This function is to update the board array
     *
     * @param arr The updated board array
     * @param row The user input row
     * @param col The user input column
     * @param count The number of times that user played
     * @return The check result
     */
    public boolean updateBoard(int[][] arr, int row, int col, int count) {
        if (count % 2 == 0)
            arr[row][col] = 1;
        else arr[row][col] = -1;
        printUpdated(arr);

        return check(arr, count) != 1;
    }

    /**
     * This function is to check for winner information
     *
     * @param arr The updated board array
     * @param count The number of times that user played
     */
    private int check(int[][] arr, int count) {

        int sumSum = 0;                  // holds the diagonal sum
        int flip = 0;

        // check for tie game 
        if (count == SIZE * SIZE) {
            flip = 1;

        }
        // check for win in row and in diagonal location 
        for (int r = 0; r < arr.length; r++) {
            int sumRow = 0;                 // holds the sum for each row
            for (int c = 0; c < arr[r].length; c++) {
                sumRow += arr[r][c];        // adding up the numbers
                if ((r + c) == (SIZE - 1)) // validate the diagonal numbers
                    sumSum += arr[r][c];

                if (sumRow == SIZE || sumSum == SIZE ||
                        sumRow == -1 * SIZE ||
                        sumSum == -1 * SIZE) {
                    flip = 1;
                }
            }
        }

        // check for win in column and in diagonal location 
        int sumEqual = 0;               // holds the diagonal numbers
        for (int r = 0; r < arr.length; r++) {
            int sumCol = 0;             // holds the sum for each column
            for (int c = 0; c < arr[r].length; c++) {
                sumCol += arr[c][r];    // adding the columns
                if (r == c)             // validate the diagonal numbers
                    sumEqual += arr[c][r];

                if (sumEqual == SIZE || sumCol == SIZE ||
                        sumEqual == -1 * SIZE ||
                        sumCol == -1 * SIZE) {
                    flip = 1;
                }
            }
        }
        return flip;
    }
    /**
     * This function is to print the updated array.
     * 
     * @param arr The updated board.
     */
    public void printUpdated(int[][] arr) {
        // print for col number
        for (int k = 0; k < SIZE; k++)
            System.out.printf("%3d", k);
        System.out.print("\n");

        // print for player input location
        for (int r = 0; r < arr.length; r++) {
            System.out.printf("%d",r);  // row number display
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == 1) {
                    System.out.printf("%s", "O");   // display for O
                }
                else if (arr[r][c] == -1) {
                    System.out.printf("%s", "X");   // display for X
                }
                else {
                    System.out.printf("%s", " ");
                }
                    System.out.print(" |");
                }
            System.out.print("\n");

            for (int c = 0; c < arr[r].length; c++)
                System.out.printf("%2s", "----");
            System.out.print("\n");
        }
    }
}
