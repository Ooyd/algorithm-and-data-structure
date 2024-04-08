import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000),시작 정점 R (1 ≤ R ≤ N)이 주어진다가 주어진다.
 - N개의 정점과 M개의 간선으로 구성된 무방향 그래프에서, 정점 R에서 시작하는 깊이 우선 탐색(DFS)을 수행하여 각 정점의 방문 순서를 출력한다.
 - 모든 간선의 가중치는 1이며, 방문할 수 없는 정점의 방문 순서는 0으로 출력한다.

 2. 개념 및 접근법
 - 깊이 우선 탐색(DFS) 알고리즘을 사용하여 각 정점을 방문한다.
 - 인접 정점은 오름차순으로 방문한다.
 - 방문 순서를 기록하기 위한 배열을 사용한다.
 - 시작 정점에서 탐색을 시작하여 모든 연결된 정점을 방문하고, 방문 순서를 기록한다.

 3. 풀이 결과
 메모리 	 ,시간
 */
public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1; // 방문 순서를 나타내는 변수

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 양방향 그래프 배열
        graph = new ArrayList[N + 1];
        // 방문 여부를 체크하는 배열
        visited = new boolean[N + 1];
        // 방문 순서 저장하는 배열
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선정보로 구선된 양방향 그래프 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb.toString());

    }




    // Stack자료구조가 아닌 재귀함수로 deps 확인
    // 방문한 순서대로 정점 저장.
    public static void dfs(int r) {
        visited[r] = true;
        order[r] = cnt++;
        for (int i : graph[r]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}

