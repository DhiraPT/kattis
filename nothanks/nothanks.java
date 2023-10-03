import java.io.*;
import java.util.*;

public class nothanks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int smallest = -1;
        int consecutiveLength = 1;
        int score = 0;
        Arrays.sort(cards);
        for (int card: cards) {
            if (smallest + consecutiveLength == card) {
                consecutiveLength++;
            } else {
                score += card;
                smallest = card;
                consecutiveLength = 1;
            }
        }
        System.out.println(score);
    }
}