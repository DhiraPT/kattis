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

class Node implements Comparable<Node> {
    public int node;
    public long distance;
    public int shamans;
    public int titans;
    public Node(int node, long distance, int shamans, int titans) {
        this.node = node;
        this.distance = distance;
        this.shamans = shamans;
        this.titans = titans;
    }
    @Override
    public int compareTo(Node n2) {
        if (this.titans == n2.titans) {
            if (this.shamans == n2.shamans) {
                return Long.compare(this.distance, n2.distance);
            }
            return Integer.compare(this.shamans, n2.shamans);
        }
        return Integer.compare(this.titans, n2.titans);
    }
}

public class fendofftitan {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        int M = fio.nextInt();
        int X = fio.nextInt();
        int Y = fio.nextInt();
        Node[] costs = new Node[N+1];
        Set<Integer> settled = new HashSet<>();
        List<Node>[] adjList = new ArrayList[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            costs[i] = new Node(i, Long.MAX_VALUE, M + 1, M + 1);
        }
        while (M-- > 0) {
            int Ai = fio.nextInt();
            int Bi = fio.nextInt();
            long Wi = fio.nextLong();
            int Ci = fio.nextInt();
            adjList[Ai].add(new Node(Bi, Wi, Ci == 1 ? 1 : 0, Ci == 2 ? 1 : 0));
            adjList[Bi].add(new Node(Ai, Wi, Ci == 1 ? 1 : 0, Ci == 2 ? 1 : 0));
        }
        pq.add(new Node(X, 0, 0, 0));
        costs[X] = new Node(X, 0, 0, 0);
        while (!pq.isEmpty()) {
            Node currNode = pq.remove();
            if (!settled.contains(currNode.node)) {
                settled.add(currNode.node);
                Node currCost = costs[currNode.node];
                for (Node neighbour: adjList[currNode.node]) {
                    if (!settled.contains(neighbour.node)) {
                        int newTitans = currCost.titans + neighbour.titans;
                        int newShamans = currCost.shamans + neighbour.shamans;
                        long newDistance = currCost.distance + neighbour.distance;
                        Node neighbourCost = costs[neighbour.node];
                        if (newTitans < neighbourCost.titans) {
                            neighbourCost.titans = newTitans;
                            neighbourCost.shamans = newShamans;
                            neighbourCost.distance = newDistance;
                        } else if (newTitans == neighbourCost.titans && newShamans < neighbourCost.shamans) {
                            neighbourCost.shamans = newShamans;
                            neighbourCost.distance = newDistance;
                        } else if (newTitans == neighbourCost.titans && newShamans == neighbourCost.shamans && newDistance < neighbourCost.distance) {
                            neighbourCost.distance = newDistance;
                        }
                        pq.add(neighbourCost);
                    }
                }
            }
        }
        if (!settled.contains(Y)) {
            fio.println("IMPOSSIBLE");
        } else {
            fio.println(costs[Y].distance + " " + costs[Y].shamans + " " + costs[Y].titans);
        }
        fio.close();
    }
}