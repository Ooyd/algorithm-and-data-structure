import java.util.*;
import java.io.*;


/**
 * 1. 문제 정리
 * - 목표 : 주어진 연산들을 수행하면서, 절댓값이 가장 작은 값을 찾아 출력하고 배열에서 제거하는 프로그램을 작성한다.
 * - 입력 :
 * - 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
 * - 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
 * - x ≠ 0: 배열에 x를 추가한다.
 * - x = 0: 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * - 절댓값이 가장 작은 값이 여러 개일 경우, 가장 작은 수를 출력하고 제거한다.
 * - 출력 :
 * - 입력에서 0이 주어진 횟수만큼, 절댓값이 가장 작은 값을 출력한다.
 * - 배열이 비어 있는 경우에 0이 입력되면 0을 출력한다.
 * <p>
 * 2. 개념 및 접근법
 * - 우선순위 큐를 사용해서 절댓값을 기준으로 정렬되게 커스텀한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int outputCount = 0;

        //절대 값 비교를 위해 우선순위 큐 커스텀
        PriorityQueue<Integer> customPq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return a - b;
            else {
                return absA - absB;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            //x가 0이 아니면 우선순위 큐에 추가.
            if(x != 0){
                customPq.add(x);
            } else {
                //큐가 비어있지 않으면 절대값이 가장 작은값 출력 후 제거
                if(!customPq.isEmpty()){
                    System.out.println(customPq.poll());
                } else {
                    //큐가 비어있으면 0 출력
                    System.out.println(0);
                }
            }
        }
    }
}




