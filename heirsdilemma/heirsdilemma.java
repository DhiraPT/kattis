import java.util.*;

public class heirsdilemma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(), H = sc.nextInt();
        int count = 0;
        while (H >= L) {
            if (checkValidDigits(H) && isDivisible(H)) {
                ++count;
            }
            --H;
        }
        System.out.println(count);
    }
    
    public static boolean checkValidDigits(int num) {
        boolean[] digits = new boolean[10];
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || digits[digit]) {
                return false;
            }
            digits[digit] = true;
            num /= 10;
        }
        return true;
    }
    
    public static boolean isDivisible(int num) {
        int oriNum = num;
        while (num > 0) {
            int digit = num % 10;
            if (oriNum % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}