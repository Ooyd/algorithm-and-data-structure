import java.io.*;
import java.util.*;


/**
 1. 문제 정리
 - 2행 n열의 스티커 배열에서 변을 공유하지 않으면서 최대 점수를 얻어야 한다.
 - 스티커를 떼면, 상하좌우의 스티커는 사용할 수 없다.

 2. 개념 및 접근법
 -  

 3. 풀이 결과
 -
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 선언
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[2][n]; 
            int[][] dp = new int[n][3];

            // 할당
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 첫 열에 대한 초기값 설정
            dp[0][0] = score[0][0];
            dp[0][1] = score[1][0];
            dp[0][2] = 0;

            // 동적 계획법을 통해 각 열의 최적 해 찾기
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + score[0][i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + score[1][i];
                dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            }

            // 마지막 열에서 가장 높은 점수를 비교
            int maxScore = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
            System.out.println(maxScore);
        }
    }
}
