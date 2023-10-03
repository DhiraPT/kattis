import java.util.Scanner;

public class undeadoralive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        if (message.contains(":)")) {
            if (message.contains(":(")) {
                System.out.println("double agent");
            } else {
                System.out.println("alive");
            }
        } else {
            if (message.contains(":(")) {
                System.out.println("undead");
            } else {
                System.out.println("machine");
            }
        }
    }
}