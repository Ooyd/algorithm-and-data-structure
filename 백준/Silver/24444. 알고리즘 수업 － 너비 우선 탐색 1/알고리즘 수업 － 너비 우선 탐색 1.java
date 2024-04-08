import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000),시작 정점 R (1 ≤ R ≤ N)이 주어진다.
 - 주어진 입력은 N개의 정점과 M개의 간선으로 구성된 무방향 그래프입니다.
 - 모든 간선의 가중치는 1입니다.
 - 정점 R에서 시작하여 너비 우선 탐색(BFS)을 통해 각 정점의 방문 순서를 출력해야 합니다.

 2. 개념 및 접근법
 - BFS를 이용한다.(Queue사용)
 - 인접한 정점(edge값)을 오름차순으로 방문하기 위해, 해당 인접 리스트를 정렬.

 3. 풀이 결과
 메모리 	 ,시간

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        int R = Integer.parseInt(st.nextToken()); //시작 값

        // 각 정점의 인접 리스트(edge값 저장) 생성
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 여부 체크와 방문 순서 기록을 위한 배열 생성
        boolean[] visited = new boolean[N + 1];
        int[] order = new int[N + 1];

        // 간선 정보를 이용한 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 그래프의 인접 리스트 오름차순으로 정렬
        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        //BFS실행
        bfs(graph, R, visited, order);

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visited, int[] order) {
        Queue<Integer> queue = new LinkedList<>();

        //시작 정점을 q에추가
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[current] = count++;

            //현재 정점기준으로 인접 정점 탐색
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }



}

