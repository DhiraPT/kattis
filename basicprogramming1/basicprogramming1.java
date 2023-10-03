import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class basicprogramming1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine1[0]);
        int t = Integer.parseInt(inputLine1[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (t == 1) {
            pw.println(7);
        } else if (t == 2) {
            if (A[0] > A[1]) {
                pw.println("Bigger");
            } else if (A[0] == A[1]) {
                pw.println("Equal");
            } else {
                pw.println("Smaller");
            }
        } else if (t == 3) {
            pw.println(Arrays.stream(A, 0, 3).sorted().toArray()[1]);
        } else if (t == 4) {
            pw.println(Arrays.stream(A).asLongStream().sum());
        } else if (t == 5) {
            long evenSum = 0;
            for (int num: A) {
                if (num % 2 == 0) {
                    evenSum += num;
                }
            }
            pw.println(evenSum);
        } else if (t == 6) {
            pw.println(Arrays.stream(A).mapToObj(x -> String.valueOf((char) ('a' + x % 26))).collect(Collectors.joining()));
        } else if (t == 7) {
            pw.println(jumpIndex(A, N));
        }
        pw.close();
    }

    public static String jumpIndex(int[] A, int N) {
        int i = 0;
        boolean[] visited = new boolean[N];
        while (true) {
            i = A[i];
            if (i < 0 || i >= N) {
                return "Out";
            } else if (i == N - 1) {
                return "Done";
            } else if (visited[i]) {
                return "Cyclic";
            }
            visited[i] = true;
        }
    }
}