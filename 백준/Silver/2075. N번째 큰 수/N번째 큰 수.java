import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리 (글 계속 적으면서 이해하기위함)
 *      - 목표 : N * N 크기의 표가 제공된다. N 번째 큰수를 찾아라
 *      - 입력 :
 *          - Line 1 : 표의 크기 N
 *          - Line N : 숫자
 *      - 출력 : N번쨰로 큰 수 찾기.
 *
 * 2. 개념 및 접근법
 *  - Priority Queue 이용
 *  - PQ의 우선순위는 숫자의 오름차순을 이용
 *  - peek값이 N번째로 오게 출력.
 */
public class Main{
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //표의 크기 N 입력
        int N = Integer.parseInt(br.readLine());

        //pq를 오름차순으로 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        //O(N^2)반복
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                //pq에 값 입력
                pq.add(num);
                //pq의 크기가 N 넘으면 N+1번째로 작은 값 제거.
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }

        //꼭대기값 확인.
        System.out.println(pq.peek());
    }
}


