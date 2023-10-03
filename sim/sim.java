import java.io.*;
import java.util.*;

public class sim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            LinkedList<Character> resultList = new LinkedList<>();
            int position = 0;
            for (char key: input.toCharArray()) {
                if (key == '[') {
                    position = 0;
                } else if (key == ']') {
                    position = resultList.size();
                } else if (key == '<') {
                    if (position > 0) {
                        resultList.remove(position - 1);
                        position--;
                    }
                } else {
                    resultList.add(position, key);
                    position++;
                }
            }
            for (char key2: resultList) {
                result.append(key2);
            }
            System.out.println(result);
        }
    }
}