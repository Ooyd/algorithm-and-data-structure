import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// 단서1
        
        int sum = 0;//단서2
        int cmp = 0;//단서 3
        for(int i=0; i<N; i++){
            int score = sc.nextInt();
            sum += score;
            
            if(cmp < score){
                cmp = score;
            }
            
        }
        System.out.println((double)sum/cmp*100/N);
        
    }
}