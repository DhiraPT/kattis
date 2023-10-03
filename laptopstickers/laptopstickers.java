import java.io.*;
import java.util.*;

public class laptopstickers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int L = Integer.parseInt(inputLine1[0]);
        int H = Integer.parseInt(inputLine1[1]);
        int K = Integer.parseInt(inputLine1[2]);
        char[][] laptopGrid = new char[H][L];
        int sticker = 97;
        for (char[] row1: laptopGrid) {
            Arrays.fill(row1, '_');
        }
        while (K-- > 0) {
            String[] inputLineSticker = br.readLine().split(" ");
            int l = Integer.parseInt(inputLineSticker[0]);
            int h = Integer.parseInt(inputLineSticker[1]);
            int a = Integer.parseInt(inputLineSticker[2]);
            int b = Integer.parseInt(inputLineSticker[3]);
            for (int i = b; i < b+h; i++) {
                for (int j = a; j < a+l; j++) {
                    if (i < H && j < L) {
                        laptopGrid[i][j] = (char) sticker;
                    }
                }
            }
            ++sticker;
        }
        for (char[] row2: laptopGrid) {
            pw.println(row2);
        }
        pw.flush();
    }
}
