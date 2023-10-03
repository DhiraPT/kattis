import java.io.*;
import java.util.Arrays;

public class height {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            String[] token = br.readLine().split(" ");
            int K = Integer.parseInt(token[0]);
            int[] heights = Arrays.stream(token).skip(1).mapToInt(Integer::parseInt).toArray();
            int steps = 0;
            for (int i = 1; i < heights.length; i++) {
                int x = heights[i];
                int j = i - 1;
                while (j >= 0 && x < heights[j]) {
                    heights[j+1] = heights[j];
                    j--;
                    steps++;
                }
                heights[j+1] = x;
            }
            pw.println(K + " " + steps);
        }
        pw.close();
    }
}