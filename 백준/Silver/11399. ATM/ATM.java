import java.util.*;
import java.io.*;

/**
 * 1. 문제 정리
 * - ATM에서 돈을 인출하는데 걸린 시간의 합의 최솟값을 구하라.
 * 2. 개념 및 접근법
 * - 오름차순으로 정렬하여 최소값부터 계산
 * 3. 풀이 결과
 * 메모리 14536 ,시간 144
 * 4. 추가 정리
 * - 처음에는 우선순위 큐를 사용한다 생각했는데, Array sort를 써도 된다라고 생각이들고, 같은 기능인데 어떤 상황일떄 쓰는게 유리할지 정리해보았다.
 * - Array 장점 :
 *      - 전체 데이터를 한 번에 메모리에 로딩, `Arrays.sort()`같은 효율적인 정렬 알고리즘을 사용해 빠르게 정렬가능.(Tim sort알고리즘)
 *      - 즉 데이터가 정적이고, 한번에 정렬을 해야 한다면 Array가 유리하다.
 * - Priority Queue :
 *      - 삽입 및 삭제 연산이 자주 발생하는 동적인 데이터셋에 유용, 왜냐하면 각 삽입 및 삭제, 즉 데이터 변동이 있을때마다 내부적으로 정렬을 유지하기에 자원을 더 잡아먹음.
 *      - 즉 데이터가 동적이고, 삽입 및 삭제가 빈번하게 발생하는 상황일떄 Priority Queue가 유리하다.
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
        int sum = 0; // 현재 사람들의 대기시간 합
        //조건: 사람들이 전부 인출할때까지
        while(!pq.isEmpty()){
            sum += pq.poll();
            total += sum;
        }
        System.out.println(total);
    }
}




