import java.util.*;
import java.io.*;


/**
 * 	15260KB	180ms
 * 1. 문제 정리
 *      - 목표 :
 *         - 카드 합체 놀이를 통해 가장 작은 점수 계산하기.
 *      - 입력 :
 *          - n (2 ≤ n ≤ 1,000): 카드의 개수.
 *          - m (0 ≤ m ≤ 15×n): 카드 합체를 하는 횟수.
 *          - a1, ... ,an 맨 처음 카드의 상태를 나타내는 n개의 자연수, 공백으로 구분되어 입력된다.
 *      - 출력 :
 *          - 만들 수 있는 가장 작은 점수를 출력한다.
 *
 * 2. 개념 및 접근법
 *  - 두 장의 카드를 선택 후 더한 값을 두 카드에 다시 넣는방식.
 *  - m번 반복한 후, 모든 카드의 수를 더한 값을 출력한다.
 *  - 가장 작은 두 수를 선택하여 합체해야함.
 *  정리
 *  - PriorityQueue를 사용해서 점수를 최소화하고 더한 값을 추가하며 m번반복
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //카드의 개수
        int n = Integer.parseInt(st.nextToken());
        //카드 합체의 횟수
        int m = Integer.parseInt(st.nextToken());

        //우선순위큐 (오름차순)
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minHeap.offer(Long.parseLong(st.nextToken()));
        }

        
        //m번 반복하며 카드 셔플
        for (int i = 0; i < m; i++) {
            long x = minHeap.poll();
            long y = minHeap.poll();

            long sum = x + y;
            minHeap.add(sum);
            minHeap.add(sum);
        }
        
        long ans = 0;
        
        //모든 카드의 합을 계산하며 출력. 텅빌떄까지
        while(!minHeap.isEmpty()){
            ans += minHeap.poll();
        }
        
        System.out.println(ans);
    }
}


