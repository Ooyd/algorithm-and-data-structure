import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int [N];
        st = new StringTokenizer(br.readLine());
        
        int low = 0;
        int high = 0;
        for(int i = 0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,trees[i]);
        }
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            // 절단기 높이가 mid일 때 얻을 수 있는 나무 길이의 합
            long sum =0;
            for(int i = 0; i < N; i++){
                if(trees[i] >= mid){
                    sum += trees[i] - mid;
                }
            }
            
            
            if(sum >= M){
                low = mid + 1;
            } else if (sum <M){
                high = mid - 1;
            }
        
        }
        System.out.println(high);
    }
}