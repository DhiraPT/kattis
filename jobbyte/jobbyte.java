import java.io.*;
import java.util.*;

public class jobbyte {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int swap = 0;
        for (int j = 0; j < N; j++) {
            while (people[j] != j + 1) {
                int currPerson = people[j];
                people[j] = people[currPerson - 1];
                people[currPerson - 1] = currPerson;
                ++swap;
            }
        }
        System.out.println(swap);
    }
}