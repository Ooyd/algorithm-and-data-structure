import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 게임 횟수 X, 이긴게임 Y가 주어진다.
 - 현재승률(Z)는 X/Y 이다.
 - 게임을 계속 이긴다고 했을 때, 승률이 바뀌는 게임의 횟수를 출력하라
 - Z가 변하지않으면 -1을 출력하라.
 - 이분탐색의 대상은 승률이다.
 2. 개념 및 접근법
 - 1 ≤ X ≤ 1,000,000,000(범위보니 이분탐색에 long써야할거같다..)
 3. 풀이 결과
 메모리 	 ,시간

 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        long z = (long)  y * 100 / x;

        if (z >= 99){
            System.out.println(-1);
            return;
        }

        long low = 1;
        long high = 1000000000;

        while(low <= high){
            long mid = (low+high) / 2;
            long newZ = (y + mid) * 100 / (x + mid);

            if(newZ <= z){
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        System.out.println(low);

    }
}



