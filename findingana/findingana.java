import java.util.*;

public class findingana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                System.out.println(s.substring(i));
                break;
            }
        }
    }
}