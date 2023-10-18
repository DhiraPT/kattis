import java.io.*;
import java.util.*;

public class proofs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> setA = new HashSet<>(200000);
        for (int i = 1; i <= n; i++) {
            String[] p = br.readLine().split("-> ");
            if (!p[0].equals("")) {
                for (String a: p[0].split(" ")) {
                    if (!setA.contains(a)) {
                        System.out.println(i);
                        return;
                    }
                }
            }
            setA.add(p[1]);
        }
        System.out.println("correct");
    }
}