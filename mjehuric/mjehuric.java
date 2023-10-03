import java.io.*;
import java.util.*;

public class mjehuric {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j);
                    String sortedArrString = String.join(" ", Arrays.stream(arr).mapToObj(Integer::toString).toArray(String[]::new));
                    pw.println(sortedArrString);
                }
            }
        }
        pw.close();
    }

    public static void swap(int[] arr, int index) {
        int temp = arr[index + 1];
        arr[index + 1] = arr[index];
        arr[index] = temp;
    }
}