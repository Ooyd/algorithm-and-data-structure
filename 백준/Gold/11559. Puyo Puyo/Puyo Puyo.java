import java.util.*;
import java.io.*;

public class Main {
    static char[][] board = new char[6][12];
    static List<Puyo> toRemove = new ArrayList<>(); // 제거할 뿌요들을 저장할 리스트
    static int bombCnt = 0;

    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Puyo {
        int x, y;
        Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 12; j++) {
            String line = br.readLine();
            for (int i = 0; i < 6; i++) {
                board[i][j] = line.charAt(i);
            }
        }

        while (true) {
            boolean anyPopped = false;
            boolean[][] visited = new boolean[6][12];

            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 12; y++) {
                    if (board[x][y] != '.' && !visited[x][y]) {
                        toRemove.clear();
                        bfs(x, y, board[x][y], visited);
                        if (toRemove.size() >= 4) {
                            for (Puyo p : toRemove) {
                                board[p.x][p.y] = '.';
                            }
                            anyPopped = true;
                        }
                    }
                }
            }

            if (!anyPopped) break;

            bombCnt++;
            dropPuyos();
        }

        System.out.println(bombCnt);
    }

    private static void bfs(int x, int y, char color, boolean[][] visited) {
        Queue<Puyo> queue = new LinkedList<>();
        queue.offer(new Puyo(x, y));
        visited[x][y] = true;
        toRemove.add(new Puyo(x, y));

        while (!queue.isEmpty()) {
            Puyo cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + pos[i][0];
                int nextY = cur.y + pos[i][1];

                if (nextX >= 0 && nextX < 6 && nextY >= 0 && nextY < 12 && !visited[nextX][nextY] && board[nextX][nextY] == color) {
                    queue.offer(new Puyo(nextX, nextY));
                    visited[nextX][nextY] = true;
                    toRemove.add(new Puyo(nextX, nextY));
                }
            }
        }
    }

    private static void dropPuyos() {
        for (int x = 0; x < 6; x++) {
            for (int y = 11; y >= 0; y--) {
                if (board[x][y] == '.') {
                    int nextY = y - 1;
                    while (nextY >= 0 && board[x][nextY] == '.') {
                        nextY--;
                    }
                    if (nextY >= 0) {
                        board[x][y] = board[x][nextY];
                        board[x][nextY] = '.';
                    }
                }
            }
        }
    }
}
