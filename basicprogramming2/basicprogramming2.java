import java.io.*;
import java.util.*;

public class basicprogramming2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine1[0]);
        int t = Integer.parseInt(inputLine1[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        if (t == 1) {
            boolean pairFound = anyPairSum7777(A, N);
            pw.println(pairFound ? "Yes" : "No");
        } else if (t == 2) {
            boolean allUnique = checkAllUnique(A, N);
            pw.println(allUnique ? "Unique" : "Contains duplicate");
        } else if (t == 3) {
            pw.println(appearMoreThan(A, N/2));
        } else if (t == 4) {
            pw.println(findMedian(A, N));
        } else if (t == 5) {
            pw.println(printRange(A));
        }
        pw.close();
    }

    public static boolean anyPairSum7777(int[] A, int N) {
        int start = 0, end = N-1;
        while (start < end) {
            if (A[start] + A[end] < 7777) {
                start++;
            } else if (A[start] + A[end] > 7777) {
                end--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAllUnique(int[] A, int N) {
        for (int i = 0; i < N - 1; i++) {
            if (A[i] == A[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    public static int appearMoreThan(int[] A, int times) {
        int count = 0, curr = A[0];
        for (int j: A) {
            if (j == curr) {
                count++;
                if (count > times) {
                    return j;
                }
            } else {
                curr = j;
                count = 0;
            }
        }
        return -1;
    }

    public static String findMedian(int[] A, int N) {
        if (N % 2 == 1) {
            return Integer.toString(A[N/2]);
        } else {
            return A[N/2-1] + " " + A[N/2];
        }
    }

    public static String printRange(int[] A) {
        StringBuilder result = new StringBuilder();
        for (int k : A) {
            if (k >= 100 && k <= 999) {
                result.append(k).append(" ");
            } else if (k > 999) {
                break;
            }
        }
        return result.toString().trim();
    }
}