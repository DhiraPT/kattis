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

public class onaveragetheyrepurple {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        int M = fio.nextInt();
        List<Integer>[] adjList = new ArrayList[N];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int j = 0; j < M; j++) {
            int a = fio.nextInt() - 1;
            int b = fio.nextInt() - 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }
        queue.add(0);
        visited[0] = true;
        outer: while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v: adjList[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                    if (v == N-1) break outer;
                }
            }
        }
        fio.println(distance[N-1] - 1);
        fio.close();
    }
}