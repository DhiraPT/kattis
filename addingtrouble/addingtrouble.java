import java.util.Scanner;

public class addingtrouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] abc = sc.nextLine().split(" ");
        if (Integer.parseInt(abc[0]) + Integer.parseInt(abc[1]) == Integer.parseInt(abc[2])) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong!");
        }
    }
}