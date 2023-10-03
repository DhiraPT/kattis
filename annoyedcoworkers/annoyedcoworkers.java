import java.io.*;
import java.util.*;

public class annoyedcoworkers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] hc = br.readLine().split(" ");
        long h = Integer.parseInt(hc[0]);
        long c = Integer.parseInt(hc[1]);
        PriorityQueue<long[]> coworkers = new PriorityQueue<>((c1, c2) -> Long.compare(c1[0] + c1[1], c2[0] + c2[1]));
        while (c-- > 0) {
            String[] ad = br.readLine().split(" ");
            long a = Long.parseLong(ad[0]);
            long d = Long.parseLong(ad[1]);
            coworkers.add(new long[]{a, d});
        }
        while (h-- > 0) {
            long[] cow = coworkers.poll();
            cow[0] += cow[1];
            coworkers.add(cow);
        }
        long annoyance = 0;
        while (!coworkers.isEmpty()) {
            annoyance = Math.max(annoyance, coworkers.poll()[0]);
        }
        System.out.println(annoyance);
    }
}