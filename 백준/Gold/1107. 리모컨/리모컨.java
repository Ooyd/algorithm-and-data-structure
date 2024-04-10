import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 수빈이는 현재 채널 100번에서 TV를 보고있다.
 - 특정 번호가 고장이 났고 N채널로 이동하고싶을때 수빈이는 채널 N으로 이동하기 위해 최소 버튼을 몇 번 눌러야하는지 구하라
 2. 개념 및 접근법
 - 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000), 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
 - 사용가능 수(0~9,+,-)이지만 일부 버튼은 고장 날 수 있다.
 - 모든 채널은 0~1,000,000까지이다.
 - +,-만으로 가는 방법과, 숫자까지 입력해서 이동하는 방법 2개를 비교해서 최소 클릭 수를 출력한다.

 3. 풀이 결과

 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        boolean[] buttons = new boolean[10];
        // true는 사용가능 false는 고장
        Arrays.fill(buttons,true);

        //런타임 에러 발생.
        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (M --> 0){
                int button = Integer.parseInt(st.nextToken());
                buttons[button] = false;
            }
        }



        // +, - 버튼만 사용했을때의 경우의 수
        int result = Math.abs(N - 100);

        //모든 채널을 순회하며 계산.(생각못해서 블로그 좀 찾아봄.)
        for (int i = 0; i <= 1000000; i++) {
            String channel = String.valueOf(i);
            int len = channel.length();

            //현재 채널의 길이가 +-만 사용한 것을 초과하면 굳이 더 탐색할 필요 없다.
            if(len + Math.abs(N - i) >= result) continue;

            //이동가능한지 확인
            boolean isMove = true;
            for (int j = 0; j < len; j++) {
                if (!buttons[channel.charAt(j) - '0']) {
                    isMove = false;
                    break;
                }
            }

            //이동가능하면 비교
            if (isMove) {
                int temp = Math.abs(i - N);
                result = Math.min(result, len + temp);
            }
        }

        System.out.println(result);



    }
}