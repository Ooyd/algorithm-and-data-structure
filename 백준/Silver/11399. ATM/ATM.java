import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리
 * - ATM에서 돈을 인출하는데 걸린 시간의 합의 최솟값을 구하라.
 * 2. 개념 및 접근법
 * - 오름차순으로 정렬하여 최소값부터 계산
 * 3. 풀이 결과
 * 메모리  ,시간
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //오름차순 정렬 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        //정렬에 value 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N --> 0){
            pq.offer(Integer.valueOf(st.nextToken()));
        }

        int total = 0; //총 대기 시간
        int sum = 0; // 각 사람별 대기 시간 누적 합
        //조건: 사람들이 전부 인출할때까지
        while(!pq.isEmpty()){
            sum += pq.poll();
            total += sum;
        }
        System.out.println(total);
    }
}




