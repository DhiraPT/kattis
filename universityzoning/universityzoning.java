import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class universityzoning {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = br.readLine().split(" ");
        long C = Long.parseLong(inputLine1[1]);
        int F = Integer.parseInt(inputLine1[2]);
        int S = Integer.parseInt(inputLine1[3]);
        int G = Integer.parseInt(inputLine1[4]);
        long[][] faculties = new long[F][];
        ArrayList<long[]> students = new ArrayList<>();
        long[] minStepsArr = new long[F];
        long minTotalSteps = 0L;
        for (int f = 0; f < F; f++) {
            String[] inputLineFac = br.readLine().split(" ");
            int K = Integer.parseInt(inputLineFac[0]);
            faculties[f] = new long[K];
            for (int k = 0; k < K; k++) {
                int rFac = Integer.parseInt(inputLineFac[2*k+1]);
                int cFac = Integer.parseInt(inputLineFac[2*k+2]);
                faculties[f][k] = rFac * C + cFac;
            }
            Arrays.sort(faculties[f]);
        }
        for (int s = 0; s < S; s++) {
            String[] inputLineStu = br.readLine().split(" ");
            int rStu = Integer.parseInt(inputLineStu[0]);
            int cStu = Integer.parseInt(inputLineStu[1]);
            long studentNo = Long.parseLong(inputLineStu[2]);
            int faculty = Integer.parseInt(inputLineStu[3]);
            students.add(new long[]{rStu * C + cStu, studentNo, faculty});
        }
        String[] TInputLine = br.readLine().split(" ");
        for (int f1 = 0; f1 < F; f1++) {
            final int f2 = f1 + 1;
            int T = Integer.parseInt(TInputLine[f1]);
            List<long[]> filteredStudents = students.stream()
                .filter(arr -> arr[2] == f2)
                .collect(Collectors.toList());
            Collections.sort(filteredStudents, (a, b) -> Long.compare(a[1], b[1]));
            minStepsArr[f1] = minSumStepsForEachFaculty(faculties[f1], filteredStudents, T, C);
        }
        Arrays.sort(minStepsArr);
        for (int j = 0; j < G; j++) {
            minTotalSteps += minStepsArr[j];
        }
        System.out.println(minTotalSteps);
    }

    public static long minSumStepsForEachFaculty(long[] faculty, List<long[]> students, int minStudents, long C) {
        long minSteps = 0L;
        int numStudents = students.size();
        if (minStudents == 0) {
            return 0;
        }
        long[] steps = new long[numStudents];
        for (int i = 0; i < numStudents; i++) {
            steps[i] = Math.abs(faculty[i]%C - students.get(i)[0]%C) + Math.abs(faculty[i]/C - students.get(i)[0]/C);
        }
        Arrays.sort(steps);
        for (int j = 0; j < minStudents; j++) {
            minSteps += steps[j];
        }
        return minSteps;
    }
}