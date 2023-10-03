import java.io.*;
import java.util.*;

public class janeeyre {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        int n = Integer.parseInt(inputLine1[0]);
        int m = Integer.parseInt(inputLine1[1]);
        String k = inputLine1[2];
        long time = 0;
        PriorityQueue<String[]> books = new PriorityQueue<>((book1, book2) -> (book1[0]).compareTo(book2[0]));
        PriorityQueue<String[]> givenBooks = new PriorityQueue<>((book1, book2) -> Integer.compare(Integer.parseInt(book1[0]), Integer.parseInt(book2[0])));
        while (n-- > 0) {
            String[] book = br.readLine().split("\"");
            books.add(new String[]{book[1], book[2].trim()});
        }
        books.add(new String[]{"Jane Eyre", k});
        while (m-- > 0) {
            String[] book = br.readLine().split("\"");
            givenBooks.add(new String[]{book[0].trim(), book[1], book[2].trim()});
        }
        while (!books.isEmpty()) {
            String[] readBook = books.poll();
            time += Integer.parseInt(readBook[1]);
            if (readBook[0].equals("Jane Eyre")) break;
            while (!givenBooks.isEmpty()) {
                if (time >= Integer.parseInt(givenBooks.peek()[0])) {
                    String[] givenBook = givenBooks.poll();
                    books.add(new String[]{givenBook[1], givenBook[2]});
                } else {
                    break;
                }
            }
        }
        System.out.println(time);
    }
}