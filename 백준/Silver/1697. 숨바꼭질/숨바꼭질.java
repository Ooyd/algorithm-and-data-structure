import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 - X-1 or X+1, 2*X만큼 이동할 수 있다.
 - 수빈이와 동생의 위치가 주어졌을때, 수빈이가 동생을 찾을 수 있는 최소 시간을 구하라.
 2. 개념 및 접근법
 - BFS 사용.
 -
 3. 풀이 결과

 */
public class Main {


    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);

    }

    private static void bfs(int n, int k) {

        int[] visited = new int[100001];
//        if(n > k){
//            visited = new int[n + 1];
//        } else {
//            visited = new int[k + 1];
//        }

        //배열 내부 값을 정의 해줘야함.
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;


        while (!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == k){
                System.out.println(visited[cur]);
                return;
            }

            //현재 값에서 갈수있는 값들 셋팅
            int[] nexts = {cur - 1, cur + 1, 2 * cur};
            for(int next : nexts){
                //전제조건을 범위 내부로 잡아야함. 아니면 ArrayIndexOutOfBoundsExcetpion이 무조건 뜸.
                if(next >= 0 && visited.length > next && visited[next] == -1){
                    queue.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }


        }

    }


}