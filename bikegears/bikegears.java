import java.io.*;
import java.util.*;

public class bikegears {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        br.readLine();
        int[] front = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] back = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<int[]> gears = new ArrayList<>();
        for (int f: front) {
            for (int b: back) {
                gears.add(new int[]{f, b});
            }
        }
        Collections.sort(gears, (gear1, gear2) -> {
            int res = Long.compare(gear1[0] * (long) gear2[1], gear2[0] * (long) gear1[1]);
            if (res == 0) {
                return Integer.compare(gear1[0], gear2[0]);
            }
            return res;
        });
        for (int[] gear: gears) {
            pw.println("(" + gear[0] + "," + gear[1] + ")");
        }
        pw.close();
    }
}