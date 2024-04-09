import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 스카이라인의 지점 개수 n이 주어진다. (1 ≤ n ≤ 50,000)
 - 스카이라인의 고도가 변하는 지점의 x, y 좌표가 주어진다. (1 ≤ x ≤ 1,000,000, 0 ≤ y ≤ 500,000)
 - 첫번째 지점의 x 좌표는 항상 1이다.
 - 스카이라인을 통해 건물이 최소 몇채인지 추정한다.

 2. 개념 및 접근법
 -
 3. 풀이 결과

 */
public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        Stack<Integer> buildingHeight = new Stack<>();

        while(n --> 0){
            StringTokenizer st =new StringTokenizer(br.readLine());
            //사용하지않는 x값 할당하지않음
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());

            //건물이 0이면 스택초기화하고 다시해야됨... 이거를 놓쳐서 몇번을 실패했는지..
            if(y == 0) {
                buildingHeight.clear();
                continue;
            }

            //건물이 한대 이상 있으며, 전 건물이 현재높이보다 클 때
            while (!buildingHeight.isEmpty() && buildingHeight.peek() > y){
                buildingHeight.pop();
            }

            //높이 갱신
            if(buildingHeight.isEmpty() || buildingHeight.peek() < y){
                buildingHeight.push(y);
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}