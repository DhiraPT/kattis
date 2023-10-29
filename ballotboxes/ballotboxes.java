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

public class ballotboxes {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        while (true) {
            int N = fio.nextInt();
            int B = fio.nextInt();
            if (N == -1 && B == -1) break;
            ArrayList<Integer> cities = new ArrayList<>();
            long sum = 0;
            int l = 1, r = 1;
            while (N-- > 0) {
                int c = fio.nextInt();
                cities.add(c);
                sum += c;
                r = Math.max(r, c);
            }
            l = (int) (sum / B);
            int res = r;
            while (l <= r) {
                int m = (l + r) / 2;
                if (check(m, cities, B)) {
                    res = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            fio.println(res);
        }
        fio.close();
    }
    static boolean check(int m, List<Integer> cities, int B) {
        int b = 0;
        boolean valid = true;
        for (int c: cities) {
            b += (int) Math.ceil(c / (double) m);
            if (B < b) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}