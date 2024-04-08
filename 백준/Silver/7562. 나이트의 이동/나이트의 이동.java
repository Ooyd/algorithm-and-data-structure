import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 나이트가 원하는 칸에 이동할 수 있는 최소 거리를 구하라.
 2. 개념 및 접근법
 - 최소 거리 문제이기에 BFS를 사용한다.
 - 체스판의 위치를 그래프의 노드, 이동을 간선(edge)로 생각한다.
 - BFS 알고리즘은 시작 노드에서 가장 가까운 노드부터 방문하기떄문에, 목표 노드에 도달한다면, 그 시점의 이동 횟수가 최소 이동횟수가 된다.
 3. 풀이 결과

 */
public class Main {
    static class Knight {
        int x,y;
        int moveCount;
        public Knight(int x,int y, int moveCount){
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

    //출력 클래스 생성
    static StringBuilder sb = new StringBuilder();

    //나이트의 이동 방향
    static int[][] pos = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Test Case
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            //체스판 크기 조건
            int l = Integer.parseInt(br.readLine());

            //시작 좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            //도착 좌표
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(l,startX,startY,endX,endY);

        }

        System.out.println(sb);
    }

    private static void bfs(int l, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[l][l];
        Queue<Knight> queue = new LinkedList<>();
        queue.add(new Knight(startX,startY,0));
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            //현재 위치
            Knight cur = queue.poll();

            if(cur.x == endX && cur.y == endY){
                sb.append(cur.moveCount).append("\n");
            }

            //Knigh 이동
            for(int i = 0 ; i<8; i++){
                int nextX = cur.x + pos[i][0];
                int nextY = cur.y + pos[i][1];

                //체스판 내부이며, 방문하지 않았는지 확인.
                if(nextX >= 0 && nextY >= 0 && nextX < l && nextY < l && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Knight(nextX,nextY, cur.moveCount +1));
                }

            }
        }

    }


}