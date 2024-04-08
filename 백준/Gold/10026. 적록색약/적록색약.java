import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - N*N 크기의 그리드의 각 칸에 R,G,B값만 채워지는 그림이 있다.
 - 같은 색상이 상하좌우로 인접해 있으면 같은 구역으로 취급한다.
 - 적록색약인 사람은 G,R을 구분하지못해서, 같은 색상으로 취급한다.
 - 적록색약인 사람과, 아닌 사람이 볼 때의 구역 수를 각각 구하라.

 2. 개념 및 접근법
 - BFS를 사용해 각 구역의 인접 칸을 탐색하며 구역의 수를 구한다.
 - 적록색약은 R을 G로 바꾸거나, G를 R로 바꾸어 동일한 색상으로 처리하게 한다.

 3. 풀이 결과
 메모리 	 ,시간

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] graph = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        int[][] pos = {{-1,0}, {1,0}, {0,-1},{0,1}};


        // 그래프 셋팅
        for(int i =0; i<N; i++){
            String temp = br.readLine();
            for(int j = 0 ;j<N;j++){
                graph[i][j] = temp.charAt(j);
            }
        }

        //출력값 초기 변수
        int normalCnt = 0;
        int colorBlindCnt = 0;

        //일반 계산
        for(int i = 0; i<N; i++){
            for(int j =0; j < N; j++){
                if(!visited[i][j]){
                    bfs(graph,visited,pos,i,j,N);
                    normalCnt++;
                }
            }
        }


        //적록색약 셋팅
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'R') graph[i][j] = 'G';
            }
        }
        

        // 적록색약 시점 구역 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(graph, visited, pos, i, j, N);
                    colorBlindCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " +colorBlindCnt);

    }

    private static void bfs(char[][] graph, boolean[][] visited, int[][] pos, int x, int y, int n) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            for(int i =0; i < 4; i++){
                int nextX = current.x + pos[i][0];
                int nextY = current.y + pos[i][1];
                
                //ArrayIndexOut발생(범위 최대 최소값 설정 필요)
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && graph[nextX][nextY] == graph[current.x][current.y] && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.offer(new Position(nextX, nextY));
                }
            }
        }
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}