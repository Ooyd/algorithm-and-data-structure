import java.io.*;
import java.util.*;

/**
  1. 문제 정리
  -

  2. 개념 및 접근법
  - BFS(4방향,범위내,미방문, 조건 : 벽이 아니면)
  -

  3. 풀이 결과

 */

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, CNT, VCNT;
    static int[][] arr;
    static int ans;
    static List<int[]> vlst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        // [1] 입력 처리: 빈칸 개수(CNT), vlst 생성
        CNT = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {    // 빈 칸인 경우
                    CNT++;
                } else if (arr[i][j] == 2) {  // 비활성 바이러스인 경우
                    vlst.add(new int[]{i, j});
                }
            }
        }
        VCNT = vlst.size();

        // [2] VCNT개중 M개를 선택하는 모든 경우(최소값 갱신)
        if (CNT == 0) {             // 처음부터 빈칸 없음 => 0
            ans = 0;
        } else {
            ans = N * N;
            dfs(0, 0, new ArrayList<>());
            if (ans == N * N) {     // 빈칸 남아있는 경우
                ans = -1;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int n, int s, List<int[]> tempList) {
        // [1] 종료조건: 선택한 개수가 M개가 되면 종료
        if (n == M) {
            ans = Math.min(ans, bfs(tempList));
            return;
        }

        // [2] 하부함수 호출
        for (int j = s; j < VCNT; j++) {
            tempList.add(vlst.get(j));
            dfs(n + 1, j + 1, new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
        }
    }

    static int bfs(List<int[]> tlst) {
        // [1] q생성, v[]생성
        Queue<int[]> q = new LinkedList<>();
        int[][] v = new int[N][N];

        // [2] q에 초기데이터(들) 삽입, v표시
        for (int[] t : tlst) {
            int ti = t[0];
            int tj = t[1];
            q.add(new int[]{ti, tj});
            v[ti][tj] = 1;
        }

        int cnt = CNT;       // 빈칸의 개수: 빈칸에 확산될때마다 1씩 감소
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int ci = c[0];
            int cj = c[1];
            for (int[] d : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int ni = ci + d[0];
                int nj = cj + d[1];
                // 네방향, 범위내, 미방문, **조건(벽이아니면)
                if (0 <= ni && ni < N && 0 <= nj && nj < N && v[ni][nj] == 0 && arr[ni][nj] != 1) {
                    q.add(new int[]{ni, nj});
                    v[ni][nj] = v[ci][cj] + 1;
                    if (arr[ni][nj] == 0) {      // 빈칸인경우
                        cnt--;
                        if (cnt == 0) {          // 모든 빈칸 채운경우 소요시간 리턴
                            return v[ni][nj] - 1;
                        }
                    }
                }
            }
        }

        // while 내에서 리턴 못한 경우 ==> 빈칸 남아있음..!
        return N * N;
    }
}