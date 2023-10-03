import java.io.*;

public class coffeecupcombo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int index = 0;
        int lecturesAwake = 0;
        int coffee = 0;
        while (index < n) {
            if (s.charAt(index) == '1') {
                lecturesAwake += 1;
                coffee = 2;
            } else {
                if (coffee > 0) {
                    lecturesAwake += 1;
                    coffee -= 1;
                }
            }
            index += 1;
        }
        System.out.println(lecturesAwake);
    }
}