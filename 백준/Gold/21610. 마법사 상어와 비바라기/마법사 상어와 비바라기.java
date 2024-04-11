import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 필드크기는 N * N이다.
 - 구름의 이동 명령 횟수는 M이다.
 - 비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생성된다.
 - 구름이 이동 입력값에 따라 이동한다.
 - 구름이 있는 위치에 물의 양이 1씩 증가한다.
 - 물복사 버그 발생 -> 구름이 있던 칸의 대각선 방향에 있는 바구니 중 물이 있는 바구니의 수 만큼 해당칸 물의 양 증가.
 - 구름이 있던 칸을 제외한 칸들중 물의양이 2이상인 칸에 구름이 생겨난다.
 - 4,5,6,7줄 m만큼반복한다.

 2. 개념 및 접근법
 - 필요한 변수들은 static으로 선언하고 메서드로 각 행동을 쪼개서 작업하자.

 3. 풀이 결과

 */
public class Main {
    static int N,M;
    static int[][] field;

    static boolean[][] visited;
    static ArrayList<Cloud> clouds = new ArrayList<>();

    static int move[][] = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};


    static class Cloud{
        int x,y;

        private Cloud(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //할당
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //(N, 1), (N, 2), (N-1, 1), (N-1, 2)
        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            //구름 이동
            moveClouds(d,s);

            //비내리기
            rain();

            //물복사 버그발생
            waterBug();

            //구름생성
            makeCloud();
        }


        sumWater();

    }

    private static void sumWater() {
        int res = 0;
        for(int i = 0; i<N;i++){
            for(int j =0; j<N;j++){
                res += field[i][j];
            }
        }
        System.out.println(res);
    }

    private static void makeCloud() {
        clouds = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for (int j = 0; j<N; j++){
                if(!visited[i][j] && field[i][j] >= 2){
                    clouds.add(new Cloud(i,j));

                    field[i][j] -= 2;
                }
            }
        }
    }

    private static void waterBug() {
        for(Cloud cloud : clouds){

            for(int i = 1; i<8; i += 2){
                int nx = cloud.x + move[i][0];
                int ny = cloud.y + move[i][1];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && field[nx][ny] >= 1){
                    field[cloud.x][cloud.y]++;
                }
            }
        }
    }


    private static void rain() {
        for(Cloud cloud : clouds){
            field[cloud.x][cloud.y]++;
        }
    }

    private static void moveClouds(int d, int s) {
        ArrayList<Cloud> moveClouds = new ArrayList<>();
        visited = new boolean[N][N];

        for(Cloud cloud: clouds){
            int nx = Math.floorMod(cloud.x + move[d][0] * s, N);
            int ny = Math.floorMod(cloud.y + move[d][1] * s, N);

            moveClouds.add(new Cloud(nx,ny));
            visited[nx][ny] = true;
        }

        clouds = moveClouds;
    }



}