import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueYN = false;

        do{
            clearBoard();
            int moves = 0;
            String player = "O";
            continueYN = false;
            boolean done = false;
            boolean endgame = false;
            do{
                if(player.equals("X")){
                    player = "O";
                }else{
                    player = "X";
                }
                System.out.println("\nIt is player " + player + " turn!");
                do {
                    done = false;
                    int moveRow = SafeInput.getRangedInt(in, "What is the row of your move?", 1, 3);
                    int moveCol = SafeInput.getRangedInt(in, "What is the column of your move?", 1, 3);
                    moveRow = moveRow - 1;
                    moveCol = moveCol - 1;
                    if (checkMove(moveRow, moveCol)) {
                        board[moveRow][moveCol] = player;
                        moves += 1;
                        done = true;
                        display();
                    } else {
                        System.out.println("That is not a valid move!");
                        display();
                    }
                    if(moves == 9){
                        endgame = true;
                    }
                    else if(moves >= 1){
                        if(isWin(player)){
                            endgame = true;
                        }
                    }
                }while(!done);
            }while(!endgame);
            if(!isWin(player)){
                System.out.println("\nIt is a TIE!!");
            }
            continueYN = SafeInput.getYNConfirm(in,"Would you like to play again?");
        }while(continueYN);
    } // end of main
    private static void clearBoard(){
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                board[row][col] = " ";
            }
        }
        display();
    }
    private static void display() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(" | "+ board[row][col]);
            }
            System.out.print(" | ");
            System.out.print("\n");
            System.out.print("--------------");
            System.out.print("\n");
        }
    }
    private static boolean checkMove(int row,int col){
        boolean valid = false;
        if(board[row][col].equals(" ")){
            valid = true;
        }
        return valid;
    }
    private static boolean isWin(String player){
        boolean win = false;
        if(rowWin()||colWin()||isDiagonalWin(player)){
            win = true;
        }
        return win;
    }
    private static boolean colWin(){
        boolean win = false;
        int counter = 0;
        for(int col = 0; col < COL; col++) {
            String checker = board[0][col];
            counter = 0;
            if(checker.equals("X")||checker.equals("O")) {
                for (int row = 0; row < ROW; row++) {
                    if (board[row][col].equals(checker)) {
                        counter++;
                        if (counter == 3) {
                            win = true;
                            System.out.println("\nPlayer " + checker + " is a winner!!");
                        }
                    }
                }
            }
        }
        return win;
    }
    private static boolean rowWin(){
        boolean win = false;
        int counter = 0;
        for(int row = 0; row < ROW; row++) {
            String checker = board[row][0];
            counter = 0;
            if(checker.equals("X")||checker.equals("O")) {
                for (int col = 0; col < COL; col++) {
                    if (board[row][col].equals(checker)) {
                        counter++;
                        if (counter == 3) {
                            win = true;
                            System.out.println("\nPlayer " + checker + " is a winner!!");
                        }
                    }
                }
            }
        }
        return win;
    }
    private static boolean isDiagonalWin(String player) {
        boolean diagWin = true;
        for (int i = 0; i < COL; i++) {
            if(!board[i][i].equals(player)) {
                diagWin = false;
            }
        }
        if(diagWin) {
            System.out.println("\nPlayer " + player + " is a Winner!!!");
            return true;
        }
        for (int i = 0; i < COL; i++) {
            if (!board[i][COL-1-i].equals(player)) {
                return false;
            }
        }
        System.out.println("\nPlayer " + player + " is a Winner!!!");
        return true;
    }
}