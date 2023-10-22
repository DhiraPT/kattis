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

public class bank {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt(), T = fio.nextInt();
        ArrayList<int[]> q = new ArrayList<>();
        long sum = 0;
        while (N-- > 0) {
            int c = fio.nextInt(), t = fio.nextInt();
            q.add(new int[]{c, t});
        }
        q.sort((p1, p2) -> {
            int cmp = p2[0] - p1[0];
            if (cmp == 0) return p1[1] - p2[1];
            return cmp;
        });
        boolean[] times = new boolean[T];
        for (int j = T-1; j >= 0; j--) {
            if (!times[j] && !q.isEmpty()) {
                for (int[] p: q) {
                    if (j <= p[1]) {
                        times[j] = true;
                        sum += p[0];
                        q.remove(p);
                        break;
                    }
                }
            }
        }
        fio.println(sum);
        fio.close();
    }
}