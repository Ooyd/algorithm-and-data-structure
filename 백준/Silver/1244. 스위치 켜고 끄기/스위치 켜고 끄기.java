import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] switchOnOff = new int [n];

    for(int i =0; i<n; i++){
      switchOnOff[i] = Integer.parseInt(st.nextToken());
    }

    int people = Integer.parseInt(br.readLine());

    for(int i=0; i<people; i++){
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int number = Integer.parseInt(st.nextToken());
      switchOnOff = switchCheck(n,gender, number, switchOnOff);
    }


    //한 줄에 20개씩 출력
    for(int i=0; i<n; i++) {
      System.out.print(switchOnOff[i] + " ");
      if((i+1) % 20 == 0)
        System.out.println();
    }  }

  private static int[] switchCheck(int n, int gender, int number, int[] switchOnOff) {
    if(gender == 1){
      for(int i =0; i< n; i++){
        if((i+1) % number == 0){
          switchOnOff[i] = switchOnOff[i] == 0? 1:0;
        }
      }
    } else if (gender == 2){
      switchOnOff[number - 1] = switchOnOff[number - 1] == 0 ? 1 : 0;
      int left = number - 1;
      int right = number - 1;
      while (left >= 0 && right < n && switchOnOff[left] == switchOnOff[right]) {
        switchOnOff[left] = switchOnOff[left] == 0? 1:0;
        switchOnOff[right] = switchOnOff[right] == 0? 1:0;
        left--;
        right++;
      }
    } else {
      System.out.println("의도하지 않은 성별을 입력하셨습니다.");
    }
    return switchOnOff;
  }

}