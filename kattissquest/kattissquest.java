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

public class kattissquest {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        while (N-- > 0) {
            String S = fio.next();
            int energy = fio.nextInt();
            if (S.equals("add")) {
                map.computeIfAbsent(energy, k -> new PriorityQueue<>(Comparator.reverseOrder())).add(fio.nextInt());
            } else {
                long totalGold = 0;
                Integer key = map.floorKey(energy);
                while (key != null) {
                    PriorityQueue<Integer> pq = map.get(key);
                    while (key <= energy && !pq.isEmpty()) {
                        energy -= key;
                        totalGold += pq.poll();
                        if (pq.isEmpty()) map.remove(key);
                    }
                    key = map.floorKey(energy);
                }
                fio.println(totalGold);
            }
        }
        fio.close();
    }
}