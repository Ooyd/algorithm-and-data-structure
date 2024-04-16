import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] grid;
    static int sharkX, sharkY, sharkSize = 2;
    static int fishEaten = 0, totalTime = 0;
    static int[] dx = { -1, 0, 1, 0 }; // 상, 좌, 하, 우
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        grid = new int[N][N];

        // 초기 맵 설정, 상어 위치 확인
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    grid[i][j] = 0;
                }
            }
        }

        boolean canEat = true;
        while (canEat) {
            int[] fish = findFish();
            if (fish == null) {
                canEat = false;
            } else {
                eatFish(fish);
            }
        }

        System.out.println(totalTime);
    }

    // 가장 가까운 먹을 수 있는 물고기 찾기
    static int[] findFish() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sharkX, sharkY, 0 });
        visited[sharkX][sharkY] = true;

        int[] closestFish = null;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            // 먹을 수 있는 물고기 발견 시 로직
            if (grid[x][y] > 0 && grid[x][y] < sharkSize) {
                if (closestFish == null || dist < closestFish[2] || (dist == closestFish[2] && (x < closestFish[0] || (x == closestFish[0] && y < closestFish[1])))) {
                    closestFish = new int[] { x, y, dist };
                }
            }

            // 이동 가능한 칸 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] <= sharkSize) {
                    queue.add(new int[] { nx, ny, dist + 1 });
                    visited[nx][ny] = true;
                }
            }
        }

        return closestFish;
    }

    // 물고기를 먹고 상어 위치 및 크기 업데이트
    static void eatFish(int[] fish) {
        int x = fish[0], y = fish[1], dist = fish[2];

        // 물고기 먹기
        grid[x][y] = 0;
        sharkX = x;
        sharkY = y;
        totalTime += dist;
        fishEaten++;

        // 상어 크기 업데이트
        if (fishEaten == sharkSize) {
            sharkSize++;
            fishEaten = 0;
        }
    }
}
