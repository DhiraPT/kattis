import java.io.*;
import java.util.*;

class Song {
    int index;
    long f;
    long z;
    String title;

    public Song(int index, long f, long q, String title) {
        this.index = index;
        this.f = f;
        this.z = q;
        this.title = title;
    }
}

public class zipfsong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputLine1 = br.readLine().split(" ");
        int n = Integer.parseInt(inputLine1[0]);
        int m = Integer.parseInt(inputLine1[1]);
        ArrayList<Song> songs = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String[] songInput = br.readLine().split(" ");
            long f = Long.parseLong(songInput[0]);
            long z = (long) i * f;
            songs.add(new Song(i, f, z, songInput[1]));
        }
        Collections.sort(songs, (song1, song2) -> {
            if (song1.z > song2.z) {
                return -1;
            } else if (song1.z < song2.z) {
                return 1;
            } else {
                return Integer.compare(song1.index, song2.index);
            }
        });
        for (int j = 0; j < m; j++) {
            pw.println(songs.get(j).title);
        }
        pw.close();
    }
}