import java.util.*;

public class fyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneNum = sc.nextLine();
        String prefix = phoneNum.substring(0,3);
        if (prefix.equals("555")) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}