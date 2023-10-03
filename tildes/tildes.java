import java.io.*;
import java.util.*;

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

public class tildes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int n = Integer.parseInt(inputLine1[0]);
        int q = Integer.parseInt(inputLine1[1]);
        UnionFind UF = new UnionFind(n);
        while (q-- > 0) {
            String[] inputLine2 = br.readLine().split(" ");
            char t_s = inputLine2[0].charAt(0);
            if (t_s == 't') {
                int a = Integer.parseInt(inputLine2[1]) - 1;
                int b = Integer.parseInt(inputLine2[2]) - 1;
                UF.unionSet(a, b);
            } else {
                int a = Integer.parseInt(inputLine2[1]) - 1;
                pw.println(UF.sizeOfSet(a));
            }
        }
        pw.close();
    }
}