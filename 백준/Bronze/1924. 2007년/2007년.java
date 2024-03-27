import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] days ={"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        int sum = 0;
        if(x != 1){
            for(int i = 1; i < x; i++){
                sum += month[i - 1];
            }
        }

        sum += y;
        
        System.out.println(days[sum % 7]);
    
    }
}