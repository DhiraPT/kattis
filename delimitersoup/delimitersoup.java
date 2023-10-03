import java.io.*;
import java.util.*;

public class delimitersoup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String program = br.readLine();
        Stack<Character> validator = new Stack<>();
        for (int i = 0; i < L; i++) {
            char delimiter = program.charAt(i);
            if (delimiter != ' ') {
                if (delimiter == '(' || delimiter == '[' || delimiter == '{') {
                    validator.push(delimiter);
                } else {
                    if (!validator.isEmpty() && checkPair(validator.peek(), delimiter)) {
                        validator.pop();
                    } else {
                        System.out.print(delimiter + " " + i);
                        return;
                    }
                }
            }
        }
        System.out.println("ok so far");
    }

    public static boolean checkPair(char open, char close) {
        if ((open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}'))
            return true;
        return false;
    }
}