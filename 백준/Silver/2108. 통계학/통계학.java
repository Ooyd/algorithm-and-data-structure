import java.util.*;
import java.io.*;

/**
 1. 문제 정리
 - 산술평균, 중앙값, 최빈값(여러개있다면 두번째로 작은값),범위를 구하는 문제
 2. 개념 및 접근법
 - 배열을 생성하고 정렬이 되어있는 전제조건에서 해당 문제들을 풀어본다.
 3. 풀이 결과
 메모리 	 ,시간

 */
public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //빈도수 배열, -4000~4000까지 값 확인
        int[] freq = new int[8001];
        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        //4가지 결과값에 대한 조건셋팅
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            //산술평균을 위한 전체 합
            sum += num;
            //값들에 대한 빈도수 체크
            freq[num + 4000]++;
            //숫자 배열 넣기
            numbers.add(num);
        }

        Collections.sort(numbers);

        // 산술평균
        double mean = (double) sum / n;
        sb.append(Math.round(mean)).append('\n');

        // 중앙값
        int median = numbers.get(n / 2);
        sb.append(median).append('\n');

        // 최빈값 찾기
        int maxFrequency = 0;
        for (int i = 0; i < 8001; i++) {
            if (freq[i] > maxFrequency) {
                maxFrequency = freq[i];
            }
        }

        //최빈값 확인
        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (freq[i] == maxFrequency) {
                modes.add(i - 4000);
            }
        }

        Collections.sort(modes);
        if (modes.size() > 1) {
            sb.append(modes.get(1)).append('\n');
        } else {
            sb.append(modes.get(0)).append('\n');
        }

        // 범위
        int range = numbers.get(n - 1) - numbers.get(0);
        sb.append(range);


        System.out.println(sb);

    }
}

