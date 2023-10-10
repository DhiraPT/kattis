import java.io.*;
import java.util.*;

public class bokforing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] NQ = br.readLine().split(" ");
        int Q = Integer.parseInt(NQ[1]);
        HashMap<String, String> hm = new HashMap<>();
        String currentWealth = "0";
        while (Q-- > 0) {
            String[] event = br.readLine().split(" ");
            String type = event[0];
            if (type.equals("SET")) {
                hm.put(event[1], event[2]);
            } else if (type.equals("RESTART")) {
                currentWealth = event[1];
                hm.clear();
            } else {
                if (hm.containsKey(event[1])) {
                    pw.println(hm.get(event[1]));
                } else {
                    pw.println(currentWealth);
                }
            }
        }
        pw.close();
    }
}
