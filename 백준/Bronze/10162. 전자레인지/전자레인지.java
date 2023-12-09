import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] timeSplit = new int[]{300, 60, 10};
        int[] cnt = new int[3];
        int t = sc.nextInt();
        
        for(int i =0; i<cnt.length; i++){
            cnt[i] = t /timeSplit[i];
            t %= timeSplit[i];
        }
        
        if(t != 0){
            System.out.println(-1);
        } else {
            for(int item : cnt){
                System.out.print(item + " ");
            }
        }
    }
}