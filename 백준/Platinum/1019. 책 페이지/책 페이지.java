import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 각 숫자(0~9)의 출현 횟수를 저장할 배열
    static int[] cnt;
    // 시작 페이지, 끝 페이지, 자릿수를 나타내는 변수
    static int start, end, digit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 설정
        digit = 1;  // 자릿수 초기값은 1
        start = 1;  // 시작 페이지는 1
        end = Integer.parseInt(br.readLine());  // 마지막 페이지는 입력값

        cnt = new int[10];  // 숫자 카운트를 위한 배열 초기화

        while (start <= end) {
            // 시작 페이지의 마지막 자리가 0이 될 때까지 1씩 증가시키며 카운트
            while (start % 10 != 0 && start <= end) {
                counting(start, digit);
                start++;
            }

            // 마지막 페이지의 마지막 자리가 9가 될 때까지 1씩 감소시키며 카운트
            while (end % 10 != 9 && start <= end) {
                counting(end, digit);
                end--;
            }

            if (start > end) break;

            // 자릿수를 제거하여 다음 단계로 이동
            start /= 10;
            end /= 10;

            // start ~ end 사이의 숫자 출현 횟수를 현재 자릿수만큼 증가시킴
            for (int i = 0; i < 10; ++i) {
                cnt[i] += (end - start + 1) * digit;
            }

            // 자릿수를 10배 증가
            digit *= 10;
        }

        // 결과 출력
        for (long i : cnt) {
            System.out.print(i + " ");
        }
    }

    // 주어진 숫자의 각 자릿수에 대해 출현 횟수를 계산하는 함수
    private static void counting(int num, int digit) {
        while (num > 0) {
            cnt[num % 10] += digit;
            num /= 10;
        }
    }
}
