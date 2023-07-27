import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[]args) {

        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        System.out.println("Hello!\nWelcome To The Tic-Tac-Toe Game");
        System.out.println("Against Who Would You Like To Play?\n1.Vs Player\n2.Vs Computer");
        int player_pick = getPlayerPick(sc);
        System.out.println("Please Choose Where To Put Your X 0n According To The Next Board: ");
        printBoard(new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}});
        VsPlayer(scan, board, player_pick);
        VsComputer(scan, board, player_pick);
    }

    /**
     * Returns against whom the player want to play - Computer or player2
     * @param sc - The scanned input
     * @return - Player's pick
     */
    private static int getPlayerPick(Scanner sc) {
        int player_pick = sc.nextInt();

        while((player_pick != 1 && player_pick != 2 ) ) {
            System.out.println("Error!\nPlease Choose Again:\n1.Vs Player\n2.Vs Computer");
            player_pick = sc.nextInt();
        }
        return player_pick;
    }

    /**
     * If the player chose to play against the computer so it will be computer moves
     * @param scan - The scanned input
     * @param board - Match Board
     * @param player_pick - Player pick from the getPlayerPick method
     */
    private static void VsComputer(Scanner scan, char[][] board, int player_pick) {
        while (player_pick == 2) {
            if (!GameOver(board))
                askTurn(board, scan,'X');
            if(!GameOver(board))
            ComputerTurn(board);
        }
    }

    /**
     * If the player chose to play against player so it will be player2 moves
     * @param scan - Player2 Input
     * @param board - Match Board
     * @param player_pick - From getPlayerPick method
     */
    private static void VsPlayer(Scanner scan, char[][] board, int player_pick) {

        while (player_pick == 1) {
            if (!GameOver(board))
                askTurn(board, scan,'X');
            if(!GameOver(board))
                askTurn(board, scan,'O');
        }
    }


    /**
     * Method who checks if the game is over by 3 cases:
     * 1.if X player has 3 X in a row/colum/diagonal
     * 2.if O player has 3 0 in a row/colum/diagonal
     * 3.Cases 1,2 not exists and there aren't empty spots on board
     * @param board - Match Board
     * @return -  in case of case1: Player Wins!
     *            in case of case2: Computer Wins!
     *            in case of case3: It's A Tie!
     */
    private static boolean GameOver(char[][] board) {

        if(RowOf3(board)) { //case1 or case2
            return false;
        }

        for (char[] chars : board) //case3
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == ' ')
                    return false;
            }
        printBoard(board);
        System.out.println("It's A Tie!");
        System.exit(0);
        return false;
    }

    /**
     * The method checks if there are 3 same symbols in following spots(diagonal/row/colum)
     * @param board - Match Board
     * @return - True and who wins in case of 3 following symbols
     *          - False if there isn't such a case
     */
    private static boolean RowOf3(char[][]board){

        if((board[0][0] == board[0][1]) && board[0][1] == board[0][2] && (board[0][0] == 'X')) {
            System.out.println(" X Wins!");
            System.exit(0);
        }else if((board[0][0] == board[0][1]) && board[0][1] == board[0][2] && (board[0][0] == 'O')){
            System.out.println(" O Wins!");
            System.exit(0);
            return true;
        }

        if((board[1][0] == board[1][1]) && board[1][1] == board[1][2] && (board[1][1] == 'X')) {
            System.out.println(" X Wins!");
            System.exit(0);
        }else if(((board[1][0] == board[1][1]) && board[1][1] == board[1][2] && (board[1][1] == 'O'))){
                System.out.println(" O Wins!");
            System.exit(0);
            return true;
        }

        if((board[2][0] == board[2][1]) && board[2][1] == board[2][2] && (board[2][0] == 'X')) {
                System.out.println(" X Wins!");
            System.exit(0);
        }else if((board[2][0] == board[2][1]) && board[2][1] == board[2][2] && (board[2][0] == 'O')){
                System.out.println(" O  Wins!");
            System.exit(0);
            return true;
        }

        if((board[0][0] == board[1][0]) && board[1][0] == board[2][0] && (board[0][0] == 'X')) {
            System.out.println(" X Wins!");
            System.exit(0);
        }else if((board[0][0] == board[1][0]) && board[1][0] == board[2][0] && (board[0][0] == 'O')){
                System.out.println(" O Wins!");
            System.exit(0);
            return true;
        }

        if((board[0][1] == board[1][1]) && board[1][1] == board[2][1] && (board[0][1] == 'X')) {
                System.out.println(" X Wins!");
                System.exit(0);
            }else if((board[0][1] == board[1][1]) && board[1][1] == board[2][1] &&board[0][1] == 'O') {
                System.out.println(" O Wins!");
                System.exit(0);
            return true;
        }

        if((board[0][2] == board[1][2]) && board[0][2] == board[2][2] && (board[0][2] == 'X')) {
            System.out.println(" X Wins!");
            System.exit(0);
        }else if((board[0][2] == board[1][2]) && board[0][2] == board[2][2] && (board[0][2] == 'O')){
                System.out.println(" O Wins!");
            System.exit(0);
            return true;
        }

        if((board[0][0] == board[1][1]) && board[1][1] == board[2][2] && (board[0][0] == 'X')) {
            System.out.println(" X Wins!");
            System.exit(0);
        }else if((board[0][0] == board[1][1]) && board[1][1] == board[2][2] && (board[0][0] == 'O')){
                System.out.println(" O Wins!");
            System.exit(0);
            return true;
        }
        return false;
    }

    /**
     * The method is to play the computer turn:
     * by selecting an available random spot on board in his turn
     * @param board - Match Board
     */
    private static void ComputerTurn(char[][] board) {
        Random random = new Random();
        int computerPlay;

        do {
            computerPlay = random.nextInt(9) + 1; // Choose a random number from 1 to 9
        } while (!isValid(board, String.valueOf(computerPlay)));
        System.out.println("Computer Chose " + computerPlay); //Prints the computer choose
        Turn(board, String.valueOf(computerPlay),'O'); //Put it on board
    }

    /**
     * The method checks if the pick of user/computer is valid
     * by checking if the spot hasn't already taken
     * @param board - Match board
     * @param pick - User Input
     * @return True - if the spot is available
     *          False - if the spot is already taken
     */
    private static boolean isValid(char[][]board,String pick){

         switch (pick) {
            case "1":
                return (board[0][0] == ' ');
             case "2":
                 return board[0][1] == ' ';
             case "3":
                 return board[0][2] == ' ';
             case "4":
                 return board[1][0] == ' ';
             case "5":
                 return board[1][1] == ' ';
             case "6":
                 return board[1][2] == ' ';
             case "7":
                 return board[2][0] == ' ';
             case "8":
                 return board[2][1] == ' ';
             case "9":
                 return board[2][2] == ' ';
             default:
                 return false;
        }
    }

    /**
     * The method is the player turn
     * @param board - Match board
     * @param scan - Scanning his input where to play
     */
    private static void askTurn(char[][] board,Scanner scan,char symbol) {
        String userInput;
        while (true) {
            System.out.println("Where Would You Like To Play?");
            userInput = scan.nextLine(); //Scanning his play
            if (isValid(board, userInput)) //Valid move
                break;
            else
                System.out.println("Please Choose A Valid Move"); //In case of invalid move
        }
        Turn(board, userInput, symbol);

    }

    /**
     * Turning the spots on board into the symbols according to the match events
     * @param board - Match board
     * @param userInput - Only legal values
     * @param symbol - 'X' or 'O'
     */
    private static void Turn(char[][] board,String userInput,char symbol) {
        switch (userInput) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println("Illegal Action!\nChoose A Legal Value");
        }
        printBoard(board);
    }


    /**
     * Printing the board up to the match events
     * @param board - Match board
     */
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]); // First Row
        System.out.println("-+-+-"); //Limit
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]); // Second Row
        System.out.println("-+-+-"); //Limit
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]); //Third Row
    }
}

