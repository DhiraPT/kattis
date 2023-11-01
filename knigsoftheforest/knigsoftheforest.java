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

class Moose {
    int year;
    int strength;
    public Moose(int year, int strength) {
        this.year = year;
        this.strength = strength;
    }
}

public class knigsoftheforest {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int k = fio.nextInt(); // size of tournament pool
        int n = fio.nextInt(); // number of years for which u have been suplpied enoguh info
        Moose karl = new Moose(fio.nextInt(), fio.nextInt());
        PriorityQueue<Moose> waitingPq = new PriorityQueue<>((m1, m2) -> Integer.compare(m1.year, m2.year));
        PriorityQueue<Moose> currentPq = new PriorityQueue<>((m1, m2) -> Integer.compare(m2.strength, m1.strength));
        int year = 2011;
        if (karl.year > year) {
            waitingPq.add(karl);
        } else {
            currentPq.add(karl);
        }
        for (int i = 0; i < n + k - 2; i++) {
            Moose m = new Moose(fio.nextInt(), fio.nextInt());
            if (m.year > year) {
                waitingPq.add(m);
            } else {
                currentPq.add(m);
            }
        }
        while (!currentPq.isEmpty()) {
            Moose wM = currentPq.poll();
            if (wM.equals(karl)) {
                fio.println(year);
                break;
            }
            year++;
            if (!waitingPq.isEmpty()) {
                if (waitingPq.peek().year == year) currentPq.add(waitingPq.poll());
            } else {
                fio.println("unknown");
                break;
            }
        }
        fio.close();
    }
}