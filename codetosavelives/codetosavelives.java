import java.io.*;

public class codetosavelives {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num1 = Integer.parseInt(br.readLine().replace(" ",""));
            int num2 = Integer.parseInt(br.readLine().replace(" ",""));
            String stringSum = Integer.toString(num1 + num2);
            StringBuilder stringSumWithSpaces = new StringBuilder();
            for (int j = 0; j < stringSum.length(); j++) {
                char digit = stringSum.charAt(j);
                stringSumWithSpaces.append(digit);
                if (j != stringSum.length()-1) {
                    stringSumWithSpaces.append(" ");
                }
            }
            pw.println(stringSumWithSpaces);
        }
        pw.close();
    }
}