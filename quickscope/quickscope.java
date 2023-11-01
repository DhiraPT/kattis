import java.io.*;
import java.util.*;

class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;
    public FastIO() {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || ! st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
}

public class quickscope {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        HashMap<String, Stack<String>> variables = new HashMap<>();
        Stack<HashSet<String>> levelSets = new Stack<>();
        HashSet<String> currentVariables = new HashSet<>();
        while (N-- > 0) {
            String[] line = fio.nextLine().split(" ");
            switch (line[0]) {
                case "DECLARE":
                    if (!variables.containsKey(line[1])) {
                        Stack<String> varStack = new Stack<>();
                        varStack.push(line[2]);
                        variables.put(line[1], varStack);
                        currentVariables.add(line[1]);
                    } else {
                        if (currentVariables.contains(line[1])) {
                            fio.println("MULTIPLE DECLARATION");
                            fio.close();
                            return;
                        } else {
                            variables.get(line[1]).push(line[2]);
                            currentVariables.add(line[1]);
                        }
                    }
                    break;
                case "TYPEOF":
                    if (!variables.containsKey(line[1])) {
                        fio.println("UNDECLARED");
                    } else {
                        fio.println(variables.get(line[1]).peek());
                    }
                    break;
                case "{":
                    levelSets.push(currentVariables);
                    currentVariables = new HashSet<>();
                    break;
                case "}":
                    for (var variable: currentVariables) {
                        variables.get(variable).pop();
                        if (variables.get(variable).isEmpty()) variables.remove(variable);
                    }
                    currentVariables = levelSets.pop();
                    break;
            }
        }
        fio.close();
    }
}