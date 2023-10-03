import java.io.*;
import java.util.*;

public class speedrun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] GN = br.readLine().split(" ");
        int G = Integer.parseInt(GN[0]);
        int N = Integer.parseInt(GN[1]);
        ArrayList<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            tasks.add(new int[]{a, b});
        }
        tasks.sort((task1, task2) -> {
            return Integer.compare(task1[1], task2[1]);
        });
        int currTime = 0;
        for (int i = 0; i < N; i++) {
            if (tasks.get(i)[0] >= currTime) {
                G--;
                currTime = tasks.get(i)[1];
            }
            if (G <= 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}