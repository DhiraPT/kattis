import java.io.*;

public class thanos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] token = br.readLine().split(" ");
            long P = Long.parseLong(token[0]);
            long R = Long.parseLong(token[1]);
            long F = Long.parseLong(token[2]);
            int year = 0;
            while (P <= F) {
                P *= R;
                ++year;
            }
            pw.println(year);
        }
        pw.close();
    }
}