import java.io.*;

public class tenis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] players = br.readLine().split(" ");
        int numMatches = Integer.parseInt(br.readLine());
        for (int i = 0; i < numMatches; i++) {
            int playerOneWin = 0, playerTwoWin = 0;
            boolean valid = true;
            String[] matchResult = br.readLine().split(" ");
            if (matchResult.length > 3 || matchResult.length < 2) {
                pw.println("ne");
                continue;
            }
            for (int j = 0; j < matchResult.length; j++) {
                if (j == 2 && playerOneWin != 1 && playerTwoWin != 1) {
                    pw.println("ne");
                    valid = false;
                    break;
                }
                String[] set = matchResult[j].split(":");
                int playerOneScore = Integer.parseInt(set[0]), playerTwoScore = Integer.parseInt(set[1]);
                // Check if Player 1 win is valid
                if (playerOneScore > playerTwoScore && !players[1].equals("federer")) {
                    if (playerTwoScore <= 5
                            && (playerOneScore < playerTwoScore + 2 || playerOneScore < 6 || playerOneScore > 7)) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else if (j <= 1 && playerTwoScore > 5 && playerOneScore != 7) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else if (j == 2 && playerTwoScore >= 6 && playerOneScore != playerTwoScore + 2) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else {
                        playerOneWin++;
                    }
                    // Check if Player 2 win is valid
                } else if (playerTwoScore > playerOneScore && !players[0].equals("federer")) {
                    if (playerOneScore <= 5
                            && (playerTwoScore < playerOneScore + 2 || playerTwoScore < 6 || playerTwoScore > 7)) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else if (j <= 1 && playerOneScore > 5 && playerTwoScore != 7) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else if (j == 2 && playerOneScore >= 6 && playerTwoScore != playerOneScore + 2) {
                        pw.println("ne");
                        valid = false;
                        break;
                    } else {
                        playerTwoWin++;
                    }
                } else {
                    pw.println("ne");
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if (playerOneWin == playerTwoWin) {
                    pw.println("ne");
                } else {
                    pw.println("da");
                }
            }
        }
        pw.close();
    }
}