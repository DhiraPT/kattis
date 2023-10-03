import java.io.*;
import java.util.*;

public class coconut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int s = Integer.parseInt(inputLine1[0]);
        int n = Integer.parseInt(inputLine1[1]);
        Deque<Integer[]> hands = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) hands.add(new Integer[]{i, 0});
        int s2 = s;
        while (hands.size() > 1) {
            while (s2-- > 0) {
                Integer[] currHand = hands.poll();
                if (hands.size() == 1 && currHand[0] == hands.peek()[0]) break;
                if (s2 == 0 && currHand[1] == 0) {
                    currHand[1] = 1;
                    hands.addFirst(currHand);
                    hands.addFirst(new Integer[]{currHand[0], 1});
                } else if (s2 == 0 && currHand[1] == 1) {
                    currHand[1] = 2;
                    hands.add(currHand);
                } else if (s2 != 0) {
                    hands.add(currHand);
                }
            }
            s2 = s;
        }
        System.out.println(hands.peek()[0]);
    }
}