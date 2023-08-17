import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> s = new Stack<>();

    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      q.offer(Integer.parseInt(st.nextToken()));
    }
    int start = 1;

    while (!q.isEmpty()){ //q가 빌떄까지 반복
      int frontStudent = q.poll();
      if(frontStudent == start){
        start++;

        while (!s.isEmpty() && s.peek() == start){
          s.pop();
          start++;
        }
      } else{
        s.push(frontStudent);
      }
    }

    while (!s.isEmpty() && s.peek() == start){ // s이 빌떄까지 반복.
      s.pop();
      start++;
    }


    System.out.println((s.isEmpty()? "Nice" : "Sad"));

  }
}