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

public class kannafriendship {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        fio.nextInt();
        int Q = fio.nextInt();
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        int count = 0;
        while (Q-- > 0) {
            int t = fio.nextInt();
            if (t == 1) {
                int s = fio.nextInt(), e = fio.nextInt();
                Integer si = intervals.lowerKey(s);
                if (si != null) {
                    int ei = intervals.get(si);
                    if (ei >= e) {
                        continue;
                    } else if (ei >= s - 1) {
                        count -= ei - si + 1;
                        s = si;
                        intervals.remove(si);
                    }
                }
                si = intervals.ceilingKey(s);
                while (si != null && si <= e + 1) {
                    int ei = intervals.get(si);
                    if (e < ei) e = ei;
                    count -= ei - si + 1;
                    intervals.remove(si);
                    si = intervals.ceilingKey(s);
                }
                count += e - s + 1;
                intervals.put(s, e);
            } else {
                fio.println(count);
            }
        }
        fio.close();
    }
}