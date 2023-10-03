import java.io.*;

public class backspace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder res = new StringBuilder();
        for (char i: input.toCharArray()) {
            if (i != '<') {
                res.append(i);
            } else if (res.length() > 0) {
                res.deleteCharAt(res.length() - 1);
            }
        }
        System.out.println(res);
    }
}