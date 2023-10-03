import java.util.Scanner;

public class sifferprodukt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        while (x.length() > 1) {
            x = product(x);
        }
        System.out.println(x);
    }
    
    private static String product(String x) {
        int product = 1;
        for (int i = 0; i < x.length(); i++) {
            if (Character.getNumericValue(x.charAt(i)) != 0) {
                product *= Character.getNumericValue(x.charAt(i));
            }
        }
        return Integer.toString(product);
    }
}