import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>(); // 풍선 인덱스를 저장
        int[] arr = new int[N]; // 풍선에 적힌 숫자 저장

        for (int i = 0; i < N; i++) {
            deque.offer(i); // 인덱스를 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N]; // 결과값을 저장할 배열
        int resultIndex = 0; // 결과 배열의 인덱스

        int steps = 0; // 다음 풍선으로 이동할 단계
        while (!deque.isEmpty()) {
            int current = deque.pollFirst(); // 현재 터트릴 풍선
            result[resultIndex++] = current + 1; // 실제 풍선 번호는 인덱스 + 1

            if (deque.isEmpty()) break; // 모든 풍선이 터졌으면 종료

            steps = arr[current]; // 다음 이동을 위한 단계 업데이트

            if (steps > 0) {
                for (int i = 0; i < steps - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(steps); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
