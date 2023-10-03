import java.io.*;
import java.util.*;

public class stokigalistor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sortedArrA = arrA.clone();
        int count = 0;
        Arrays.sort(sortedArrA);
        for (int i = 0; i < N; i++) {
            if (arrA[i] != sortedArrA[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}