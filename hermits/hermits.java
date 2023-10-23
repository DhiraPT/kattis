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

public class hermits {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = fio.nextInt();
        }
        List<Integer>[] adjList = new ArrayList[N];
        for (int j = 0; j < N; j++) {
            adjList[j] = new ArrayList<>();
        }
        int M = fio.nextInt();
        while (M-- > 0) {
            int s1 = fio.nextInt() - 1, s2 = fio.nextInt() - 1;
            adjList[s1].add(s2);
            adjList[s2].add(s1);
        }
        long minPeople = Long.MAX_VALUE;
        int qStreet = -1;
        for (int k = 0; k < N; k++) {
            long totalPeople = people[k];
            boolean isSmallest = totalPeople < minPeople;
            if (isSmallest) {
                for (int street: adjList[k]) {
                    totalPeople += people[street];
                    if (totalPeople >= minPeople) {
                        isSmallest = false;
                        break;
                    }
                }
            }
            if (isSmallest) {
                minPeople = totalPeople;
                qStreet = k;
            }
        }
        fio.println(qStreet + 1);
        fio.close();
    }
}