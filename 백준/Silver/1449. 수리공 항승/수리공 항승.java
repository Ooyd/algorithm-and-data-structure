import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int L = sc.nextInt();
        
        int[] leaks = new int[N];
        
        for(int i=0; i < N; i++){
            leaks[i] = sc.nextInt();
        }
        
        Arrays.sort(leaks);
        
        int count = 0;
        int lastCovered = 0;
        
        for(int i=0; i< N; i++){
            if(leaks[i] > lastCovered){
                count++;
                lastCovered = leaks[i] + L - 1;
            }
        }
        
        System.out.println(count);
    }
}