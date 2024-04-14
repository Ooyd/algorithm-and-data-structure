import java.io.*;
import java.util.*;

/**
 1. 문제 정리
 - 현서는 최소 비용으로 이동하고 싶어함.
 - N개(1 <= N <= 50,000)의 헛간, 소들의 길 M(1<=M<=50,000), 길에 C_i마리(0<=C_i<=1,000)의 소가 있습니다.
 - 소를 만나면 마리당 1개의 여물을 줘야합니다.
 - 현서는 1에 있고, 찬홍이는 N에 있습니다.
 -
 2. 개념 및 접근법
 - N(헛간)은 Node, M(소들의 길)은 Edge, C_i(소의 마리 수)는 cost로 사용한다. 무방향의 가중치 graph
 - 1에서 N까지 가는 최소비용을 구하는 문제. 다익스트라 알고리즘 사용.
 - N의 값이 최대 50,000이기에 N^2를 하게되면 25억. 인접 행렬로 사용하게되면 메모리 과다. 인접 리스트 사용
 -

 3. 풀이 결과

 */

class Main {
    /**
     * 1. graph 구성시 - 몇번 간선(no)인지? 해당 간선의 비용(cost)은 얼마인가
     * 2. dijkstra 사용시 - 출발점 -> 해당 간선의 누적비용(cumCost)이 계산 되어야함, 간선번호(no)도 있음.
     * 3. P.Q. - Edge관리 -> 누적 비용을 통해서 정렬.
     */
    private static class Edge implements Comparable<Edge> {
        int no, cost, cumcost;

        Edge(int no, int cost, int cumcost) {
            this.no = no;
            this.cost = cost;
            this.cumcost = cumcost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cumcost, other.cumcost); //최소비용 -> 오름차순
        }
    }

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n; // (1 <= N <= 50,000)개의 헛간 - 인접 리스트
    static int m; // (1 <= M <= 50,000)개의 양방향 길 - 무향그래프
    static List<Edge>[] graph;

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //입력
        StringTokenizer st = new StringTokenizer(input.readLine());

        n = Integer.parseInt(st.nextToken()) + 1; //1번 부터 시작.
        m = Integer.parseInt(st.nextToken());

        //인접 리스트 형태로 그래프 구성
        graph = new List[n];
        for (int i = 1; i < graph.length; i++) graph[i] = new ArrayList<>();

        //양방향 그래프 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //양방향 그래프
            graph[from].add(new Edge(to, cost,0));
            graph[to].add(new Edge(from, cost,0));
        }

        // 1 --> n으로 가는 최소 비용
        res = Integer.MAX_VALUE;
        dijkstra();
        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge[] pathCost = new Edge[n];

        for (int i = 1; i < pathCost.length; i++) {
            Edge v = new Edge(i,0, Integer.MAX_VALUE);
            //출발점의 누적코스트 set
            if (i == 1){
                v.cumcost = 0;
                pq.offer(v);
            }
            pathCost[i] = v;
        }


        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            //자식 탐색
            List<Edge> list = graph[cur.no];
            for (int i = 0; i < list.size(); i++) {
                Edge next = list.get(i);
                // 기존 누적 비용이 cur를 거쳐서 온 비용보다 크다면 갱신
                if(pathCost[next.no].cumcost > cur.cumcost + next.cost){
                    pathCost[next.no].cumcost = cur.cumcost + next.cost;

                    //다음 탐색 후보로 등록
                    pq.offer(pathCost[next.no]);
                }
            }
        }

        //누적배열에 담겨있는 n번째 누적값.
        res = pathCost[n - 1].cumcost;
    }
}
