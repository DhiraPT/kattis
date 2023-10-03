import java.io.*;
import java.util.*;

public class planetaris {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int a = Integer.parseInt(inputLine1[1]);
        int[] solarSystems = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int win = 0;
        Arrays.sort(solarSystems);
        for (int solarSystem: solarSystems) {
            int shipsToWin = solarSystem + 1;
            if (a - shipsToWin >= 0) {
                a -= shipsToWin;
                win++;
            } else {
                break;
            }
        }
        System.out.println(win);
    }
}