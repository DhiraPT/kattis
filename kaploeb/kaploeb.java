import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class kaploeb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] lks = br.readLine().split(" ");
        int l = Integer.parseInt(lks[0]);
        int k = Integer.parseInt(lks[1]);
        HashMap<Integer, Integer[]> participants = new HashMap<>();
        while (l-- > 0) {
            String[] input = br.readLine().split(" ");
            int participant = Integer.parseInt(input[0]);
            String[] time = input[1].split("\\.");
            int mm = Integer.parseInt(time[0]);
            int ss = Integer.parseInt(time[1]);
            int time_ss = mm * 60 + ss;
            int totalLap = 1;
            int totalTime = time_ss;
            if (participants.containsKey(participant)) {
                totalLap = participants.get(participant)[0] + 1;
                totalTime = participants.get(participant)[1] + time_ss;
            }
            participants.put(participant, new Integer[]{totalLap, totalTime});
        }
        List<Integer> sortedParticipants = participants.entrySet().stream()
            .filter(p -> participants.get(p.getKey())[0] >= k)
            .sorted((p1, p2) -> {
                int res = p1.getValue()[1].compareTo(p2.getValue()[1]);
                if (res == 0) {
                    return p1.getKey().compareTo(p2.getKey());
                }
                return res;
            })
            .map(Map.Entry::getKey).collect(Collectors.toList());
        for (int participant: sortedParticipants) {
            pw.println(participant);
        }
        pw.close();
    }
}