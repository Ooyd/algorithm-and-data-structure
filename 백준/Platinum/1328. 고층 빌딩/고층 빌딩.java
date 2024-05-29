import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        // 3차원 DP 배열 선언
        long[][][] dp = new long[N + 1][L + 1][R + 1];

        // 초기 조건 설정
        dp[1][1][1] = 1;

        // 동적 계획법을 이용한 점화식 계산
        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    dp[n][l][r] = (dp[n-1][l-1][r] + dp[n-1][l][r-1] + (dp[n-1][l][r] * (n - 2)) % MOD) % MOD;
                }
            }
        }

        // 결과 출력
        System.out.println(dp[N][L][R]);
    }
}