import java.util.Scanner;

public class TicTacToe {
    char PLAYER_X = 'X'; 
    char PLAYER_O = 'O'; 
    char EMPTY = ' ';
    char[][] board = new char[3][3];
    Scanner scanner = new Scanner(System.in);
    int turn = 1; 
    boolean gameWon = false;
    boolean gameDraw = false;
    int count = 0;

    public static void printBoard() {
        count++; 
        System.out.println("Current board:");
        count++;
        for (int i = 0; i < 3; i++) {
            count++;
            for (int j = 0; j < 3; j++) {
                count++;
                System.out.print(board[i][j]);
                count++;
                if (j < 2) {
                    count++;
                    System.out.print("|");
                    count++;
                }
            }
            count++;
            System.out.println();
            count++;
            if (i < 2) {
                count++;
                System.out.println("-----");
                count++;
            }
        }
        count++;
    }

    public static void initializeBoard() {
        count++; 
        for (int i = 0; i < 3; i++) {
            count++;
            for (int j = 0; j < 3; j++) {
                count++;
                board[i][j] = EMPTY;
                count++;
            }
        }
        count++;
    }

    public static void main(String[] args) {
        initializeBoard();
        count++; 

        while (true) {
            count++; 
            printBoard();
            count++;

            char current = (turn % 2 == 1) ? PLAYER_X : PLAYER_O;
            count++; 
            System.out.println("Player " + current + "'s turn.");
            count++;
            System.out.print("Enter row and column (0-2) ");
            count++;
            int row = scanner.nextInt();
            count++;
            int col = scanner.nextInt();
            count++;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                count++; 
                board[row][col] = current;
                count++;

                gameWon = false;
                count++;
                
                for (int i = 0; i < 3; i++) {
                    count++;
                    if (board[i][0] == current && board[i][1] == current && board[i][2] == current) {
                        count++;
                        gameWon = true;
                        count++;
                        break;
                    }
                }

                if (!gameWon) {
                    count++;
                    for (int i = 0; i < 3; i++) {
                        count++;
                        if (board[0][i] == current && board[1][i] == current && board[2][i] == current) {
                            count++;
                            gameWon = true;
                            count++;
                            break;
                        }
                    }
                }
            
                if (!gameWon) {
                    count++;
                    if (board[0][0] == current && board[1][1] == current && board[2][2] == current) {
                        count++;
                        gameWon = true;
                        count++;
                    } else if (board[0][2] == current && board[1][1] == current && board[2][0] == current) {
                        count++;
                        gameWon = true;
                        count++;
                    }
                }

                if (!gameWon) {
                    count++;
                    gameDraw = true;
                    count++;
                    for (int i = 0; i < 3; i++) {
                        count++;
                        for (int j = 0; j < 3; j++) {
                            count++;
                            if (board[i][j] == EMPTY) {
                                count++;
                                gameDraw = false;
                                count++;
                                break;
                            }
                        }
                    }
                }

                if (gameWon) {
                    count++;
                    System.out.println("Player " + current + " wins!");
                    count++;
                    break;
                } else if (gameDraw) {
                    count++;
                    System.out.println("The game is a draw!");
                    count++;
                    break;
                }

                turn++;
                count++; 

            } else {
                count++; 
                System.out.println("This move is not valid. Try again.");
                count++;
            }
        }

        scanner.close();
        count++;
        System.out.println("Total count of statements executed: " + count);
        count++
    }
}
