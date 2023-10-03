import java.io.*;
import java.util.Arrays;

public class sortofsorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr, (student1, student2) -> {
                return student1.substring(0, 2).compareTo(student2.substring(0, 2));
            });
            for (String student: arr) {
                pw.println(student);
            }
            pw.println();
        }
        pw.close();
    }
}