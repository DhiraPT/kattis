import java.io.*;
import java.util.*;

public class skolavslutningen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine1[0]), M = Integer.parseInt(inputLine1[1]), K = Integer.parseInt(inputLine1[2]);
        int hatColors = M;
        HashSet<Character> classes = new HashSet<Character>();
        char[][] students = new char[N][M];
        for (int i = 0; i < N; i++) {
            students[i] = br.readLine().toCharArray();
        }
        for (int column = 0; column < M; column++) {
            if (classes.size() >= K) {
                hatColors -= M - column;
                break;
            }
            boolean columnColorChanged = false;
            HashSet<Character> currentColumnClasses = new HashSet<Character>();
            for (char[] studentRow : students) {
                if (classes.contains(studentRow[column])) {
                    if (columnColorChanged == false && column != 0) {
                        hatColors--;
                        columnColorChanged = true;
                    }
                } else {
                    currentColumnClasses.add(studentRow[column]);
                }
            }
            classes.addAll(currentColumnClasses);
        }
        System.out.println(hatColors);
    }
}