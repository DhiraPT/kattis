import java.io.*;
import java.util.*;

public class rationalsequence3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            String[] dataset = br.readLine().split(" ");
            int K = Integer.parseInt(dataset[0]);
            int N = Integer.parseInt(dataset[1]);
            Stack<Character> element = new Stack<>();
            while (N > 1) {
                if ((N & 1) == 1) {
                    element.push('R');
                } else {
                    element.push('L');
                }
                N = N >> 1;
            }
            int p = 1, q = 1;
            while (!element.isEmpty()) {
                char lr = element.pop();
                if (lr == 'L') {
                    q += p;
                } else {
                    p += q;
                }
            }
            pw.println(K + " " + p + "/" + q);
        }
        pw.close();
    }
}