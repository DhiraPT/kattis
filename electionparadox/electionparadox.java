import java.io.*;
import java.util.*;

public class electionparadox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] populations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = sumLargestNumberOfVotes(populations);
        System.out.println(sum);
    }
    
    private static int sumLargestNumberOfVotes(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i >= arr.length/2+1) {
                sum += arr[i];
            } else {
                sum += arr[i]/2;
            }
        }
        return sum;
    }
}