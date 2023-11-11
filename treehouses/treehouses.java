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

class UnionFind {
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) { 
        if (p.get(i) == i) return i;
        else {
            int ret = findSet(p.get(i)); p.set(i, ret);
            return ret; } }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) { numSets--; 
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
            else {
                p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }

    public int numDisjointSets() { return numSets; }
    public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}

class Node {
    public int id;
    public double x;
    public double y;
    public Node(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    public Node n1, n2;
    public double length;
    public Edge(Node n1, Node n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.length = Edge.findLength(n1, n2);
    }
    @Override
    public int compareTo(Edge e2) {
        return Double.compare(this.length, e2.length);
    }
    public static double findLength(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }
}

public class treehouses {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int e = fio.nextInt();
        int p = fio.nextInt();
        Node[] treehouses = new Node[n];
        for (int t = 0; t < n; t++) {
            treehouses[t] = new Node(t, fio.nextDouble(), fio.nextDouble());
        }
        UnionFind UF = new UnionFind(n);
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 1; i < e; i++) {
            UF.unionSet(0, i);
        }
        while (p-- > 0) {
            UF.unionSet(fio.nextInt() - 1, fio.nextInt() - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                edges.add(new Edge(treehouses[i], treehouses[j]));
            }
        }
        double totalLength = 0;
        while (!edges.isEmpty() && UF.sizeOfSet(0) != n) {
            Edge edge = edges.poll();
            if (!UF.isSameSet(edge.n1.id, edge.n2.id)) {
                UF.unionSet(edge.n1.id, edge.n2.id);
                totalLength += edge.length;
            }
        }
        fio.println(totalLength);
        fio.close();
    }
}