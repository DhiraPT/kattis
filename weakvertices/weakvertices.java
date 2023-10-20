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

public class weakvertices {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        while (true) {
            int n = fio.nextInt();
            if (n == -1) break;
            Set<Integer>[] neighbours = new HashSet[n];
            for (int r = 0; r < n; r++) {
                neighbours[r] = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (fio.nextInt() == 1) neighbours[r].add(c);
                }
            }
            for (int i = 0; i < n; i++) {
                boolean weak = true;
                outer:
                for (int j: neighbours[i]) {
                    for (int k: neighbours[i]) {
                        if (j != k && neighbours[j].contains(k)) {
                            weak = false;
                            break outer;
                        }
                    }
                }
                if (weak) fio.print(i + " ");
            }
            fio.println();
        }
        fio.close();
    }
}