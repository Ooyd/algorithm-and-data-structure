import java.util.*;
import java.io.*;

public class Main{

    /**
     * Input Value
     * 1 Line -> 테스트케이스의 수
     * 2 Line -> N : 문서 개수 / M : 내가 궁금한 문서의 위치
     * 3 Line -> N개의 문서 중요도.
     * 2,3Line repeat * TestCaseCount
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치
            
            st = new StringTokenizer(br.readLine());
            int temp = solve(st,N,M);

            res.add(temp);

        }

        // 각 테스트 케이스의 결과 출력
        for(int num : res){
            System.out.println(num);
        }

    }


    private static int solve(StringTokenizer st, int N, int M) {
        Queue<Integer> queue = new LinkedList<>();
        int[] documents = new int[N]; // 문서의 중요도 저장
        int printOrder = 0; // 인쇄 순서

        for(int i = 0; i < N; i++){
            documents[i] = Integer.parseInt(st.nextToken()); // 중요도 저장
            queue.offer(i); // 문서의 위치 저장
        }

        while(!queue.isEmpty()){
            int current = queue.poll(); //현재 문서 확인
            boolean isMax = true; //가장 중요한 문서라고 가정

            //큐에 남아있는 모든 문서를 확인하며 현재 문서보다 중요한게 있는지 체크.
            for(int i : queue) {
                if (documents[current] < documents[i]) {
                    isMax = false;
                    queue.offer(current);
                    break;
                }
            }

            //현재 문서가 중요한 문서면은 인쇄 처리
            if(isMax){
                printOrder++; //순서 증가
                if (current == M){ 
                    return printOrder; //인쇄순서 반환.
                }
            }
        }

        return 0;
    }
}