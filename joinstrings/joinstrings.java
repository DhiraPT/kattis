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
        for (int i = 0; i < N; i++) {
            arrS[i] = fio.nextLine();
        }
        if (N == 1) {
            fio.println(arrS[0]);
        } else {
            LinkedList<String> result = new LinkedList<>();
            while (N-- > 1) {
                int a = fio.nextInt() - 1;
                int b = fio.nextInt() - 1;
                if (arrS[a].equals("")) {
                    result.add(arrS[b]);
                    arrS[b] = "";
                } else if (arrS[b].equals("")) {
                    result.addFirst(arrS[a]);
                    arrS[a] = "";
                } else {
                    result.add(arrS[a]);
                    result.add(arrS[b]);
                    arrS[a] = "";
                    arrS[b] = "";
                }
            }
            fio.println(String.join("", result));
        }
        fio.close();
    }
}