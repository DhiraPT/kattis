import java.io.*;
import java.util.*;

class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;
    public FastIO() {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || ! st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
}

public class modulosolitaire {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int m = fio.nextInt();
        int n = fio.nextInt();
        int s0 = fio.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = fio.nextInt();
            arrB[i] = fio.nextInt();
        }
        Queue<int[]> sQ = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        sQ.offer(new int[]{s0, 0});
        visited.add(s0);
        while (!sQ.isEmpty()) {
            int[] s = sQ.poll();
            if (s[0] == 0) {
                fio.println(s[1]);
                fio.close();
                return;
            }
            for (int j = 0; j < n; j++) {
                int sJ = (int) (((long) s[0] * arrA[j] + arrB[j]) % m);
                if (!visited.contains(sJ)) {
                    visited.add(sJ);
                    sQ.offer(new int[]{sJ, s[1] + 1});
                }
            }
        }
        fio.println(-1);
        fio.close();
    }
}