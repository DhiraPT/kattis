import java.io.*;
import java.util.*;

public class musicyourway {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<String> attributes = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
        int m = Integer.parseInt(br.readLine());
        ArrayList<String[]> songs = new ArrayList<>();
        while (m-- > 0) {
            String[] song = br.readLine().split(" ");
            songs.add(song);
        }
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String sortAttr = br.readLine();
            int index = attributes.indexOf(sortAttr);
            Collections.sort(songs, Comparator.comparing(song -> song[index]));
            pw.println(String.join(" " ,attributes));
            for (String[] song: songs) {
                pw.println(String.join(" ", song));
            }
            pw.println();
        }
        pw.close();
    }
}