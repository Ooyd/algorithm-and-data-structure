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
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = 100 * y / x; // 현재 승률을 계산하는 공식 수정

        // 승률이 99% 이상이면 더 이상 승률을 올릴 수 없으므로 -1 출력
        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 1;
        long high = x; // high의 초기 값을 X로 설정하여 무한 루프 방지

        while (low <= high) {
            long mid = (low + high) / 2;
            long newZ = 100 * (y + mid) / (x + mid); // 새 승률 계산

            if (newZ > z) {
                high = mid - 1; // 승률이 변했으므로, 더 낮은 범위를 탐색
            } else {
                low = mid + 1; // 승률이 변하지 않으면, 더 높은 범위를 탐색
            }
        }
        System.out.println(low); // 승률이 변하는 최소 게임 횟수 출력
    }
}



