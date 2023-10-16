import java.io.*;
import java.util.*;

public class coursescheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, HashSet<String>> map = new TreeMap<>();
        while (n-- > 0) {
            String[] request = br.readLine().split(" ");
            map.computeIfAbsent(request[2], k -> new HashSet<>()).add(request[0] + request[1]);
        }
        for (Map.Entry<String, HashSet<String>> entry: map.entrySet()) {
            pw.println(entry.getKey() + " " + entry.getValue().size());
        }
        pw.close();
    }
}