import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 1; i <= n; i++){
            String spaces = new String(new char[n - i]).replace('\0', ' ');
            String stars = new String(new char[i]).replace('\0', '*');
            System.out.println( spaces + stars );
        }
    }
}