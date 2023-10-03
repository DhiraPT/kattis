import java.io.*;
import java.util.*;

public class falcondive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int m = Integer.parseInt(inputLine1[0]), n = Integer.parseInt(inputLine1[1]);
        char c = inputLine1[2].charAt(1);

        String[] frame1 = new String[m];
        String[] frame2 = new String[m];
        char[][] frame3 = new char[m][n];

        for (int i1 = 0; i1 < m; i1++) {
            frame1[i1] = br.readLine();
        }
        br.readLine();
        for (int i2 = 0; i2 < m; i2++) {
            frame2[i2] = br.readLine();
        }

        int[] firstOccurenceFrame1 = findFirstOccurence(frame1, m, c);
        int[] firstOccurenceFrame2 = findFirstOccurence(frame2, m, c);

        if (!Arrays.equals(firstOccurenceFrame1, new int[]{-1, -1}) || !Arrays.equals(firstOccurenceFrame2, new int[]{-1, -1})) {
            int[] shift = new int[]{firstOccurenceFrame2[0] - firstOccurenceFrame1[0], firstOccurenceFrame2[1] - firstOccurenceFrame1[1]};
            for (int i3 = 0; i3 < m; i3++) {
                for (int j3 = 0; j3 < n; j3++) {
                    int newRow = i3 + shift[0], newColumn = j3 + shift[1];
                    if (frame2[i3].charAt(j3) == c) {
                        if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                            frame3[newRow][newColumn] = c;
                        }
                        frame3[i3][j3] = frame1[i3].charAt(j3);
                    } else {
                        if (frame3[i3][j3] == '\0') frame3[i3][j3] = frame2[i3].charAt(j3);
                    }
                }
            }
            for (int row = 0; row < frame3.length; row++) {
                StringBuilder result = new StringBuilder();
                for (int column = 0; column < frame3[row].length; column++) {
                    result.append(frame3[row][column]);
                }
                pw.println(result);
            }
        }
        pw.close();
    }

    public static int[] findFirstOccurence(String[] arr, int numCols, char c) {
        for (int i1 = 0; i1 < numCols; i1++) {
            for (int j1 = 0; j1 < arr[i1].length(); j1++) {
                if (arr[i1].charAt(j1) == c) {
                    return new int[]{i1, j1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}