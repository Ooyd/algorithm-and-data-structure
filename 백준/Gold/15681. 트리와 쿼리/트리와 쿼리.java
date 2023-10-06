import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] tree;
    static int[] subtreeSize;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);
        
        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int U = Integer.parseInt(input[0]);
            int V = Integer.parseInt(input[1]);
            tree[U].add(V);
            tree[V].add(U);
        }
        
        dfs(R, 0);
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            output.append(subtreeSize[U]).append("\n");
        }
        
        System.out.print(output);
    }
    
    static int dfs(int node, int parent) {
        subtreeSize[node] = 1; // Counting the node itself
        
        for (int child : tree[node]) {
            if (child != parent) {
                subtreeSize[node] += dfs(child, node);
            }
        }
        
        return subtreeSize[node];
    }
}