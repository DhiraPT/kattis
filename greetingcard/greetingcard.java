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

public class greetingcard {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        HashSet<List<Long>> coordinates = new HashSet<>();
        HashSet<List<Long>> counted = new HashSet<>();
        while (n-- > 0) {
            coordinates.add(List.of(fio.nextLong(), fio.nextLong()));
        }
        ArrayList<int[]> possibles = new ArrayList<>();
        possibles.add(new int[]{0, 2018});
        possibles.add(new int[]{0, -2018});
        possibles.add(new int[]{2018, 0});
        possibles.add(new int[]{-2018, 0});
        possibles.add(new int[]{1118, 1680});
        possibles.add(new int[]{1118, -1680});
        possibles.add(new int[]{-1118, 1680});
        possibles.add(new int[]{-1118, -1680});
        possibles.add(new int[]{1680, 1118});
        possibles.add(new int[]{-1680, 1118});
        possibles.add(new int[]{1680, -1118});
        possibles.add(new int[]{-1680, -1118});
        long count = 0;
        for (List<Long> coordinate: coordinates) {
            for (int[] possible: possibles) {
                List<Long> posCoord = List.of((coordinate.get(0) + possible[0]), (coordinate.get(1) + possible[1]));
                if (!counted.contains(posCoord) && coordinates.contains(posCoord)) {
                    count++;
                    counted.add(coordinate);
                }
            }
        }
        fio.println(count);
        fio.close();
    }
}