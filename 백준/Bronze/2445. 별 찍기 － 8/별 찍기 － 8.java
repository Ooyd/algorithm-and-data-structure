import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // n=5

    for (int i = 1; i <= n  ; i++){
      String stars = new String(new char[i]).replace('\0','*');
      String spaces = new String(new char[(n-i)*2]).replace('\0',' ');
      System.out.println(stars + spaces + stars);
    }

    for (int i =1; i< n; i++){
      String stars = new String(new char[n-i]).replace('\0','*');
      String spaces = new String(new char[2*i]).replace('\0',' ');
      System.out.println(stars + spaces + stars);
    }
  }
}