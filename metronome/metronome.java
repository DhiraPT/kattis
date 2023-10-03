import java.util.Scanner;

public class metronome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println(length/4.0);
    }
}