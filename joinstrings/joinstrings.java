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
            catch (IOException  e) { e.printStackTrace(); }
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

public class joinstrings {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        String[] arrS = new String[N];
        int[] next = new int[N];
        int[] tail = new int[N];
        for (int i = 0; i < N; i++) {
            arrS[i] = fio.nextLine();
            next[i] = i;
            tail[i] = i;
        }
        int a = 0, b;
        for (int i = 0; i < N - 1; i++) {
            a = fio.nextInt() - 1;
            b = fio.nextInt() - 1;
            if (next[a] == a) {
                next[a] = b;
            } else {
                next[tail[a]] = b;
            }
            tail[a] = tail[b];
        }
        while (N-- > 0) {
            fio.print(arrS[a]);
            a = next[a];
        }
        fio.close();
    }
}