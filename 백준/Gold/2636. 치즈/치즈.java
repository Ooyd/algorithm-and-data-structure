import java.io.*;
import java.util.*;

/**
 1. 문제 정리
 - 매 시간 마다 치즈의 가장자리만 사라진다.
 - 입력으로 치즈의 정보가 주어질 때, 치즈가 모두 녹아서 없어지는데 걸린 시간과, 가장 마지막에 남아있는 치즈의 수를 출력


 2. 개념 및 접근법
 - 바깥공간인 0부터 시작해서 DFS를 수행한다. 만약 치즈를 발견하면 해당 위치를 저장
 - 찾아낸 가장자리 치즈를 녹이고, 이 과정을 모든 치즈가 녹을떄까지 반복한다.

 3. 풀이 결과

 */

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int[][] cheeseMap;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, cnt, cnt2;
    static ArrayList<Position> edgeCheeses = new ArrayList<>();


    private static class Position {
        int y, x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    /**
     4 방향 탐색
     가장자리 치즈 발견하면 리스트에 추가 후 종료.
     */
    private static void dfs(int y, int x) {
        visited[y][x] = true;
        if (cheeseMap[y][x] == 1) {
            edgeCheeses.add(new Position(y, x));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }


    public static void main(String[] args) throws IOException {
        //입력
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //맵 초기화
        cheeseMap  = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //모든 치즈가 녹을떄까지 반복
        while (true) {
            cnt2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                }
            }
            //녹아져아할 치즈를 제거.
            edgeCheeses.clear();
            dfs(0, 0);
            //녹여야할 치즈를 녹인다. 또한 녹이는 시점에서 치즈가 몇개 녹았는지 확인.
            for (Position cheese : edgeCheeses) {
                cnt2++;
                cheeseMap[cheese.y][cheese.x] = 0;
            }

            //치즈가 다 녹았는지 확인
            boolean isEmpty = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cheeseMap[i][j] != 0) isEmpty = true;
                }
            }
            //녹는게 몇번 반복했는지 확인.
            cnt++;
            //치즈가 다 녹았으면 종료
            if (!isEmpty) break;
        }

        StringBuilder sb = new StringBuilder().append(cnt).append("\n").append(cnt2);
        System.out.println(sb);
    }
}
