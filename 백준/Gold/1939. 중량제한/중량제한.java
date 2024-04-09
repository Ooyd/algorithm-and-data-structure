import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - N개의 섬과 이들을 연결하는 M개의 다리가 있는 나라가 있으며, 두 공장이 위치한 섬 끼리 수송할 수 있는 물품의 최대 중량을 구하기
 - 섬의 수(2 ≤ N ≤ 10,000), 다리의 수(1 ≤ M ≤ 100,000)이며, 각 다리는 중량 제한 C(1 ≤ C ≤ 1,000,000,000)를 가진다.
 -

 2. 개념 및 접근법
 - 모든 다리는 양방향이다. (양방향 그래프 사용)
 -
 3. 풀이 결과

 */
public class Main {
    static class Bridge {
        int targetNode,weight;

        public Bridge (int targetNode,int weight){
            this.targetNode = targetNode;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Bridge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxWeight = 0;
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Bridge(B,C));
            graph[B].add(new Bridge(A,C));
            maxWeight = Math.max(maxWeight,C);
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        int low = 1, high = maxWeight, result = 0;
        while(low <= high){
            int mid = (low + high) / 2;

            if(bfs(graph, startNode, endNode,mid,N)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }
        System.out.println(high);
    }

    private static boolean bfs(ArrayList<Bridge>[] graph, int startNode, int endNode, int mid, int n) {
        //bfs기본 구조 + visited default[-1-1-1-1]
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        queue.offer(startNode);
        visited[startNode] = startNode;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            //도달 ㅇㅅㅇ!
            if(cur == endNode){
                return true;
            }

            for(Bridge bridge : graph[cur]){
                if (visited[bridge.targetNode] == -1 && bridge.weight >= mid){
                    visited[bridge.targetNode] = cur;
                    queue.offer(bridge.targetNode);
                }
            }
        }
        //도달을 못했음
        return false;


    }
}