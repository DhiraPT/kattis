import java.io.*;
import java.util.*;

public class gearchanging {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine1[0]);
        int M = Integer.parseInt(inputLine1[1]);
        int P = Integer.parseInt(inputLine1[2]);
        int[] crankGears = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] backGears = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] cadences = new double[N*M];
        boolean change = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cadences[i*M+j] = crankGears[i] / (double) backGears[j];
            }
        }
        Arrays.sort(cadences);
        for (int p = 0; p < N*M-1; p++) {
            double cadenceIncrease = (cadences[p+1] - cadences[p]) * 100 / (double) cadences[p];
            if (cadenceIncrease > P) {
                change = true;
                System.out.println("Time to change gears!");
                return;
            }
        }
        if (change == false) {
            System.out.println("Ride on!");
        }
    }
}