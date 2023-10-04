import java.io.*;
import java.util.*;

public class bungeebuilder {
    static int pos, min, maxD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int iMax = 0;
        for (int p = 0; p < arr.length; p++) {
            iMax = arr[p] > arr[iMax] ? p : iMax;
        }
        pos = 0; min = arr[0]; maxD = 0;
        for (int i = 1; i <= iMax; i++) {
            process(i, arr);
        }
        pos = N-1; min = arr[N-1];
        for (int j = N-2; j >= iMax; j--) {
            process(j, arr);
        }
        System.out.println(maxD);
    }
    public static void process(int k, int[] arr) {
        if (arr[k] >= arr[pos]) {
            if (Math.abs(k - pos) > 1 && maxD < arr[pos] - min) {
                maxD = arr[pos] - min;
            }
            pos = k; min = arr[k];
        } else if (arr[k] < min) {
            min = arr[k];
        }
    }
}