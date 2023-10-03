import java.io.*;

public class bokhyllor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] books = br.readLine().split(" ");
        int small = Integer.parseInt(books[0]);
        int medium = Integer.parseInt(books[1]);
        int big = Integer.parseInt(books[2]);
        int shelfWidth = Integer.parseInt(br.readLine());
        int numberOfShelves = 0;
        while (small + medium + big > 0) {
            int[] smbUsed = bestShelfFitting(shelfWidth, small, medium, big);
            small -= smbUsed[0];
            medium -= smbUsed[1];
            big -= smbUsed[2];
            numberOfShelves++;
        }
        System.out.println(numberOfShelves);
    }
    
    private static int[] bestShelfFitting(int shelfWidth, int small, int medium, int big) {
        int[] smbUsed = {0, 0, 0};
        int smallestSpaceLeft = shelfWidth;
        for (int i = Math.min(shelfWidth / 3, big); i >= 0; i--) {
            int currentWidth = shelfWidth - i * 3;
            int tempWidth = currentWidth;
            if (currentWidth == 0) {
                smbUsed = new int[] {0, 0, i};
                break;
            }
            for (int j = Math.min(tempWidth / 2, medium); j >= 0; j--) {
                currentWidth = tempWidth - j * 2;
                if (currentWidth == 0) {
                    smallestSpaceLeft = 0;
                    smbUsed = new int[] {0, j, i};
                    break;
                }
                if (currentWidth <= small) {
                    smallestSpaceLeft = 0;
                    smbUsed = new int[] {currentWidth, j, i};
                    break;
                } else {
                    currentWidth -= small;
                    if (currentWidth < smallestSpaceLeft) {
                        smallestSpaceLeft = currentWidth;
                        smbUsed = new int[] {small, j, i};
                    }
                }
            }
            if (smallestSpaceLeft == 0) {
                break;
            }
        }
        return smbUsed;
    }
}