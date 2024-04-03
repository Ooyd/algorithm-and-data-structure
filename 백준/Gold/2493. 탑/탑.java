import java.util.*;
import java.io.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] heights = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop(); // 현재 탑보다 낮은 탑은 신호를 수신할 수 없으므로 제거
            }

            if(stack.isEmpty()) {
                result[i] = 0; // 수신할 탑이 없음
            } else {
                result[i] = stack.peek() + 1; // 인덱스는 0부터 시작하므로 +1
            }

            stack.push(i); // 현재 탑의 인덱스를 스택에 저장
        }

        for(int temp: result) {
            System.out.print(temp + " ");
        }
    }
}
