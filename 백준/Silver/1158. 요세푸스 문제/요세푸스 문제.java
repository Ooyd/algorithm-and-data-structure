import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    try(Scanner sc = new Scanner(System.in)){
      int n = sc.nextInt();
      int m = sc.nextInt();

      Queue<Integer> q = new LinkedList<>();
      for(int i=0; i <n; i++){
        q.add(i+1);
      }
      System.out.print("<");
      while(q.size() > 0){
        for(int i = 0; i < m-1; i++){
          q.add(q.poll());
        }
        System.out.print(q.poll());
        if(q.size() > 0){
          System.out.print(", ");
        }
      }
      System.out.print(">");
    }

  }

}