import java.io.*;
import java.util.StringTokenizer;

public class Main{
    
    static int[][] cache = new int [30][30];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // the number of test cases
        int numOfTests = Integer.parseInt(br.readLine());
        
        StringBuilder answer = new StringBuilder();
        //loop through getCombination to print out the answer
        for(int test = 0; test < numOfTests; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            answer.append(getCombination(n,r)).append("\n");
        }
        
        System.out.println(answer.toString());
        
    }
    
    private static int getCombination(int n, int r){
        if (cache[n][r] > 0){
            return cache[n][r];
        }
        
        if(n == r || r == 0){
            return cache[n][r] = 1;
        } else {
            return cache[n][r] = getCombination(n-1, r-1) + getCombination(n-1, r);
        }
    }
}