import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scan;
    static int gameLength = 0;

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ' ');
        }

        printBoard(board);
        myTurn(board);


    }
    private static void gameState(char[][] board){
        String result = "Game not finished";
        int counterX = 0;
        int counterO = 0;
        int counter_ = 0;
        int XWins = 0;
        int OWins = 0;
        int counter = 0;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    counterX++;
                } else if (board[i][j] == 'O') {
                    counterO++;
                } else if (board[i][j] == ' ') {
                    counter_++;
                }
            }
            counter++;
        }

        for (int i = 0; i < 3; i++) {
            if (Math.abs(counterX - counterO) > 1) {
                result = "Impossible";
            } else if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                XWins++;
            } else if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                OWins++;
            } else if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                OWins++;
            } else if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                XWins++;
            } else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
                XWins++;
            } else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') {
                XWins++;
            } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
                OWins++;
            } else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
                OWins++;
            }
        }
            System.out.println("X wins" + XWins);
            System.out.println("O wins" + OWins);


            if (XWins > OWins) {
                System.out.println("X wins");
                gameLength=9;
            } else if (XWins < OWins) {
                System.out.println("O wins");
                gameLength=9;
            } else if (XWins == 0 && OWins == 0 && counterX > counterO + 1) {
                System.out.println("Impossible");
            } else if (XWins == 0 && OWins == 0 && counterO > counterX + 1) {
                System.out.println("Impossible");
            } else if (XWins == 0 && OWins == 0 && counter_ > 0) {
                System.out.println("Game not finished");
            } else if (XWins == 0 && OWins == 0) {
                System.out.println("Draw");
            } else if (XWins == OWins && XWins > 0) {
                System.out.println("Impossible");
            }


    }

    private static void printBoard(char[][] board){
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }
    private static void myTurn(char[][] board) {

        while (gameLength < 9) {
            int counterInput = 0;
            int k = 0;
            int l = 0;

            Scanner scan = new Scanner(System.in);
            String inputCoordinate = scan.nextLine();
            char[] inputMatrix = new char[3];
            for (int i = 0; i < 3; i++) {
                inputMatrix[i] = inputCoordinate.charAt(counterInput);
                counterInput++;
            }
            k = inputMatrix[0] - 49;
            l = inputMatrix[2] - 49;

            if (k < 0 || l < 0 || k > 2 || l > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                myTurn(board);
            } else if (board[k][l] == ' ') {
                if (gameLength % 2 == 0) {
                    board[k][l] = 'X';
                } else {
                    board[k][l] = 'O';
                }
                printBoard(board);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                myTurn(board);
            }
            gameLength++;
           // System.out.println(gameLength);
            gameState(board);
        }
    }
    }







