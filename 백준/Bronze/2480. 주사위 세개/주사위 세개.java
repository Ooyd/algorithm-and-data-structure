import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int o = sc.nextInt();
        
        if (n == m && m == o){
            System.out.print(n*1000+10000);
        } else if (n == m || m == o || n==o){
            if(n==m) System.out.print(n*100+1000);
            else if(m == o) System.out.print(m*100+1000);
            else System.out.print(o*100+1000);
        } else{
            int largeValue = Math.max(n,Math.max(m,o));
            System.out.print(largeValue*100);
        }
        
    }
}