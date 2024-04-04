import java.util.*;
import java.io.*;


/**
 * 1. 문제 정리
 * - 목표 : 여러 묶음의 숫자 카드를 모두 하나의 묶음으로 합치기 위해 필요한 최소 비교 횟수를 구한다.
 * - 입력 :
 *     - 첫째 줄에 숫자 카드 묶음의 개수 N이 주어진다. (1 ≤ N ≤ 100,000)
 *     - 이어서 N개의 줄에 걸쳐 각 숫자 카드 묶음의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.
 * - 출력 :
 *     - 모든 카드 묶음을 하나로 합치기 위해 필요한 최소 비교 횟수를 출력한다.
 *
 * 2. 개념 및 접근법
 *  - 우선순위 큐(Priority Queue)를 사용해서 크기가 가장 작은 두 묶음의 카드를 선택하고 합친다.
 *  - 값들을 더하고, 합친 묶음을 다시 추가한다.
 *  - 하나의 묶음이 될떄 까지 반복한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //카드 묶음의 개수
        int N = Integer.parseInt(br.readLine());

        //PriorityQueue 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a ,b) -> a - b);

        //
        for(int i = 0; i< N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        //출력값
        int cardsCount= 0;
        //값이 없을때까지
        while (pq.size() > 1){
            //가장 작은값
            int min = pq.poll();
            //그 다음값
            int next = pq.poll();
            int temp = min + next;
            cardsCount += temp;
            pq.offer(temp);
        }

        System.out.println(cardsCount);
    }
}




