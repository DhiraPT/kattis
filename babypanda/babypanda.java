import java.util.Scanner;

public class babypanda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLong();
        long m = sc.nextLong();
        int count = 0;
        while (m > 0) {
            if (m%2 == 0) {
                m /= 2;
            } else {
                m -= 1;
                count += 1;
            }
        }
        System.out.println(count);
    }
}