import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 소설가 김대전은 소설의 각 장을 다른 파일에 저장하고, 최종적으로 하나의 파일로 합친다.
 - 두 파일을 합칠 때는, 두 파일의 크기의 합만큼 비용이 발생한다.
 - 모든 장을 하나의 파일로 합칠 때 필요한 최소 비용을 계산하라.
 2. 개념 및 접근법
 - 우선순위 큐를 사용해 가장 작은 크기의 파일을 합쳐나가는 방식으로 접근해본다.
 - 양의 정수 K (3 ≤ K ≤ 1,000,000), 하나의 파일 크기는 10000을 초과하지않는다.
 3. 풀이 결과

 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Test Case Cycle
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i =0; i<K;i++){
                pq.offer(Long.valueOf(st.nextToken()));
            }

            long cost = 0;

            //pq에서 2개의 파일을 꺼낼 수 있을때 까지 반복
            while (pq.size() > 1){
                long file1 = pq.poll();
                long file2 = pq.poll();

                long sum = file1 + file2;

                cost+= sum;

                pq.offer(sum);
            }
            System.out.println(cost);
        }




    }
}