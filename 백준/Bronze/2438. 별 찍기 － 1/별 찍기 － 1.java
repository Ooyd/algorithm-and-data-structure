import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 1; i <= N; i++){
            String stars = new String(new char[i]).replace("\0", "*");
            System.out.println(stars);
        }
    }
}