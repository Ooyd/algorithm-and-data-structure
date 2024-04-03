import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int[] heights = new int[N]; // 탑의 높이를 저장할 배열
        int[] receivers = new int[N]; // 각 탑에서 수신한 탑의 번호를 저장할 배열
        int[] result = new int[N];

        // 탑의 높이를 입력받아 heights 배열에 저장
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
         // 각 탑을 순회하며, 각 탑에서 발사한 레이저 신호를 수신하는 탑 찾기
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            receivers[i] = stack.isEmpty() ? 0 : stack.peek() + 1; // 탑의 인덱스는 0부터 시작하므로 +1
            stack.push(i);
            result[i] = receivers[i];
        }
        
        
        for(int res : result){
            System.out.print(res + " ");
        }
        
        
    }

}