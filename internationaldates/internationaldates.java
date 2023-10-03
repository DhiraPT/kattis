import java.util.Scanner;

public class internationaldates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] date = sc.nextLine().split("/");
        if (Integer.parseInt(date[0]) > 12) {
            System.out.println("EU");
        } else if (Integer.parseInt(date[1]) > 12) {
            System.out.println("US");
        } else {
            System.out.println("either");
        }
    }
}