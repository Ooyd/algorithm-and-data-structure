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
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int temp = solve(st,N,M);

            res.add(temp);

        }


        for(int num : res){
            System.out.println(num);
        }

    }


    private static int solve(StringTokenizer st, int N, int M) {
        Queue<Integer> queue = new LinkedList<>();
        int[] documents = new int[N];
        int printOrder = 0;

        for(int i =0; i<N; i++){
            documents[i] = Integer.parseInt(st.nextToken());
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            boolean isMax = true;

            for(int i : queue) {
                if (documents[current] < documents[i]) {
                    isMax = false;
                    break;
                }
            }

            if(isMax){
                printOrder++;
                if (current == M){
                    return printOrder;
                }
            } else {
                queue.offer(current);
            }

        }

        return printOrder;
    }
}