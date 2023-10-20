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

public class traveltheskies {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int k = fio.nextInt(), n = fio.nextInt(), m = fio.nextInt();
        int[] airports = new int[k];
        TreeMap<Integer, ArrayList<int[]>> flights = new TreeMap<>();
        TreeMap<Integer, ArrayList<int[]>> arrivals = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            flights.put(i, new ArrayList<>());
            arrivals.put(i, new ArrayList<>());
        }
        while (m-- > 0) {
            int u = fio.nextInt(), v = fio.nextInt(), d = fio.nextInt(), z = fio.nextInt();
            flights.get(d).add(new int[]{u, v, z});
        }
        for (int j = 0; j < k*n; j++) {
            int a = fio.nextInt(), b = fio.nextInt(), c = fio.nextInt();
            arrivals.get(b).add(new int[]{a, c});
        }
        boolean isOptimal = true;
        outer: for (int s = 1; s <= n; s++) {
            for (int[] arrival: arrivals.get(s)) {
                airports[arrival[0]-1] += arrival[1];
            }
            for (int[] flight: flights.get(s)) {
                if (flight[2] > airports[flight[0]-1]) {
                    fio.println("suboptimal");
                    isOptimal = false;
                    break outer;
                }
                airports[flight[0]-1] -= flight[2];
            }
            for (int[] flight: flights.get(s)) {
                airports[flight[1]-1] += flight[2];
            }
        }
        if (isOptimal) fio.println("optimal");
        fio.close();
    }
}