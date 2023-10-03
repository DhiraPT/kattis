import java.io.*;

public class vemvinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = br.readLine().replace(" ", "").toCharArray();
        }
        
        if (checkWinner(board, 'X')) {
            System.out.println("Johan har vunnit");
        } else if (checkWinner(board, 'O')) {
            System.out.println("Abdullah har vunnit");
        } else {
            System.out.println("ingen har vunnit");
        }
    }
    
    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}