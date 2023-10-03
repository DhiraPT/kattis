import java.io.*;
import java.util.*;

public class rankproblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int n = Integer.parseInt(inputLine1[0]), m = Integer.parseInt(inputLine1[1]);
        ArrayList<String> rankList = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            rankList.add("T" + i);
        }
        while (m-- > 0) {
            String[] gameResult = br.readLine().split(" ");
            String winTeam = gameResult[0], loseTeam = gameResult[1];
            int winTeamRank = rankList.indexOf(winTeam), loseTeamRank = rankList.indexOf(loseTeam);
            if (winTeamRank > loseTeamRank) {
                rankList.remove(loseTeam);
                rankList.add(winTeamRank, loseTeam);
            }
        }
        System.out.println(String.join(" ", rankList));
    }
}