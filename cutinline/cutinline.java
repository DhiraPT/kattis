import java.io.*;
import java.util.*;

public class cutinline {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> line = new ArrayList<String>();
        while (N-- > 0) {
            line.add(br.readLine());
        }
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            String[] event = br.readLine().split(" ");
            if (event[0].equals("leave")) {
                line.remove(event[1]);
            } else if (event[0].equals("cut")) {
                line.add(line.indexOf(event[2]), event[1]);
            }
        }
        for (String name: line) {
            pw.println(name);
        }
        pw.close();
    }
}