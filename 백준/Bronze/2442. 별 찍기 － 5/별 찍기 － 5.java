import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 1; i <= N; i++) {
      String spaces = new String(new char[N - i]).replace("\0"," ");
      String stars = new String(new char[2*i-1]).replace("\0", "*");

      System.out.println(spaces + stars);
    }
  }
}