import java.io.*;
import java.util.*;


/**
 1. 문제 정리
 - 고속도로에 설치된 N개의 센서와 최대 K개의 집중국을 고려하여, 모든 센서가 최소 하나의 집중국과 연결되도록 하면서
 집중국의 수신 가능 영역의 합을 최소화하는 문제이다. 각 센서의 위치는 정수 좌표로 주어진다.
 
 2. 개념 및 접근법
 - 우선 센서들의 위치를 정렬해 인접 센서간의 거리를 계산
 - 가장 긴 거리부터 K-1개의 거리를 커트해 센서들을 K개의 그룹으로 분할
 - 각 그룹은 집중국에 의해 커버되며, 각 그룹의 길이의 합이 최소가 되도록 작성

 3. 풀이 결과
 -
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 집중국 수가 센서 수 이상이면 커버 가능하므로 0 출력
        if (K >= N) {
            System.out.println(0);
            return;
        }

        // 센서 배열 정렬
        Arrays.sort(sensors);

        // 센서간의 거리를 계산하여 배열에 저장
        int[] gaps = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gaps[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 배열 정렬
        Arrays.sort(gaps);

        // 큰 거리의 K-1개를 제외한 나머지 거리의 합을 계산
        int minCoverage = 0;
        for (int i = 0; i < N - K; i++) {
            minCoverage += gaps[i];
        }

        System.out.println(minCoverage);
    }
}