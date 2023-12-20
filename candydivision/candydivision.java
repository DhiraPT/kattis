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

public class candydivision {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        long N = fio.nextLong();
        PriorityQueue<Long> friends = new PriorityQueue<>();
        for (long i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                friends.add(i - 1);
                if (i-1 != N/i-1) friends.add(N / i - 1);
            }
        }
        while (!friends.isEmpty()) fio.print(friends.poll() + " ");
        fio.close();
    }
}