import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - M명이 N개의 심사대에서 심사를 받는다, 이때 각 심사대마다 소요되는 시간이 다른데, 해당시간들을 고려하여 심사를 받는데 걸리는 시간의 최솟값을 출력하라.
 2. 개념 및 접근법
 - 1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000 (int 사용)(계산시 long 고려) ->탐색범위가 큼
 - 이분탐색을 사용한다.
 - 기준은 심사시간이며 정렬해야한다.
 -
 -
 -
 3. 풀이 결과
 메모리 	 ,시간
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 시간배열 입력
        int[] times = new int[n];
        for(int i = 0; i< n; i++){
            times[i] = Integer.parseInt(br.readLine());
        }

        //기본정렬
        Arrays.sort(times);

        long low = 0;
        long high = (long) times[times.length - 1] * m;
        long result = high;

        while (low <= high){
            long mid = (low + high) / 2;

            //mid 시간에 몇명이 심사할수 있는지 확인.
            long count = 0;
            for(int i = 0; i< n && count <= m; i++){
                count += mid / times[i];
            }

            // 조건 검사: 현재 mid 시간으로 모든 사람을 심사할 수 있는지 여부
            if(count >= m){
                high = mid - 1;
                result = mid;
            } else if (count < m){
                low = mid + 1;

            }
        }
        System.out.println(result);
    }
}



