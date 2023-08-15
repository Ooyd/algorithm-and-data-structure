import java.io.*;
import java.util.*;

public class Main {

  public void solution() {
    int N = 0;
    int[] numbers = {};

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      numbers = new int[N];

      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    int[] structure = new int[4];
    String answer = "YES";

    for (int i = 0; i < N; i++) {
      boolean isPush = false;
      for (int stack = 0; stack < 4; stack++){
        isPush = structure[stack] < numbers[i];
        if (isPush){
          structure[stack] = numbers[i];
          break;
        }
      }

      if(!isPush){
        answer = "NO";
        break;
      }
    }
    System.out.println(answer);

  }

  public static void main(String[] args) {
    new Main().solution();
  }
}