import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        StringTokenizer st = new StringTokenizer(read.readLine());
        for (int i = 0; i < n; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(read.readLine());
        for(int i=0; i < n; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        int solution = 0;
        
        for(int i = 0; i < arrA.length; i++){
            solution += arrB[i] * arrA[arrA.length - i - 1];
        }
        
        System.out.println(solution);
        
        
    }
}