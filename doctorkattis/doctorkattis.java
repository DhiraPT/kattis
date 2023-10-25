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

class Cat implements Comparable<Cat> {
    static int currentId = 0;
    int id;
    String name;
    int injuryLevel;
    public Cat(String name, int injuryLevel) {
        this.name = name;
        this.injuryLevel = injuryLevel;
        this.id = Cat.currentId;
        Cat.currentId++;
    }
    public Cat(String name, int injuryLevel, int id) {
        this.name = name;
        this.injuryLevel = injuryLevel;
        this.id = id;
    }
    @Override
    public int compareTo (Cat c2) {
        if (this.injuryLevel == c2.injuryLevel) {
            return Integer.compare(this.id, c2.id);
        }
        return Integer.compare(c2.injuryLevel, this.injuryLevel);
    }
}

public class doctorkattis {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        HashMap<String, Cat> catsMap = new HashMap<>();
        PriorityQueue<Cat> catsPq = new PriorityQueue<>();
        while (N-- > 0) {
            switch (fio.nextInt()) {
                case 0: {
                    String name = fio.next();
                    int injuryLevel = fio.nextInt();
                    Cat newCat = new Cat(name, injuryLevel);
                    catsMap.put(name, newCat);
                    catsPq.add(newCat);
                    break;
                }
                case 1: {
                    String name = fio.next();
                    int injuryIncrease = fio.nextInt();
                    Cat cat = catsMap.get(name);
                    catsMap.remove(name);
                    Cat newCat = new Cat(name, cat.injuryLevel + injuryIncrease, cat.id);
                    catsMap.put(name, newCat);
                    catsPq.add(newCat);
                    break;
                }
                case 2: {
                    String name = fio.next();
                    catsMap.remove(name);
                    break;
                }
                case 3: {
                    if (catsMap.isEmpty()) fio.println("The clinic is empty");
                    else {
                        while (!catsMap.containsKey(catsPq.peek().name)) {
                            catsPq.poll();
                        }
                        fio.println(catsPq.peek().name);
                    }
                    break;
                }
            }
        }
        fio.close();
    }
}