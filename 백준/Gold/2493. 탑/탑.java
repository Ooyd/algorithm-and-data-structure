import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>(); //탑의 인덱스 저장
        int[] heights = new int[N]; // 탑의 높이를 저장할 배열
        int[] result = new int[N]; // 각 탑에서 수신한 탑의 번호를 저장할 배열

        // 탑의 높이를 입력받아 heights 배열에 저장
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        // 각 탑을 순회하며, 각 탑에서 발사한 레이저 신호를 수신하는 탑 찾기
        // 즉 stack의 인덱스의 꼭대기값을 비교해서 현재 값보다 낮은 index는 전부 제거.
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            int n  = stack.isEmpty() ? 0 : stack.peek() + 1; // 인덱스와 실제 순서와 1의 차이.
            sb.append(n).append(" ");
            stack.push(i);
        }


        System.out.print(sb.toString());


    }

}