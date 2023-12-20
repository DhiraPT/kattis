import java.io.*;
import java.util.*;

public class builddeps {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static HashMap<String, List<String>> dfMap = new HashMap<>();
    static HashSet<String> visited = new HashSet<>();
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] inputLine = br.readLine().split(":");
            if (inputLine.length > 1) {
                for (String dep: inputLine[1].trim().split(" ")) {
                    dfMap.computeIfAbsent(dep, k -> new ArrayList<>()).add(inputLine[0]);
                }
            }
        }
        dfs(br.readLine());
        while (!stack.isEmpty()) {
            pw.println(stack.pop());
        }
        pw.close();
    }
    static void dfs(String dep) {
        visited.add(dep);
        if (dfMap.containsKey(dep)) {
            for (String file: dfMap.get(dep)) {
                if (!visited.contains(file)) {
                    dfs(file);
                }
            }
        }
        stack.push(dep);
    }
}