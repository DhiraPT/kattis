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

public class reachableroads {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n-- > 0) {
            int m = fio.nextInt(), r = fio.nextInt();
            List<Integer>[] roads = new ArrayList[m];
            boolean[] visited = new boolean[m];
            int c = 0;
            for (int i = 0; i < m; i++) {
                roads[i] = new ArrayList<>();
            }
            while (r-- > 0) {
                int e1 = fio.nextInt(), e2 = fio.nextInt();
                roads[e1].add(e2);
                roads[e2].add(e1);
            }
            for (int j = 0; j < m; j++) {
                if (!visited[j]) {
                    dfs(j, visited, roads);
                    c++;
                }
            }
            fio.println(c-1);
        }
        fio.close();
    }
    static void dfs(int e, boolean[] visited, List<Integer>[] roads) {
        visited[e] = true;
        for (int e2: roads[e]) {
            if (!visited[e2]) {
                dfs(e2, visited, roads);
            }
        }
    }
}