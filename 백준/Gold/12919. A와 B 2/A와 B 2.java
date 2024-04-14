import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String s, t;

    public static void main(String[] args) throws IOException {
        // 입력
        s = input.readLine();
        t = input.readLine();

        System.out.println(canTransform(t) ? 1 : 0);
    }

    private static boolean canTransform(String current) {
        // 기저 조건: 현재 문자열이 s와 같은 경우
        if (current.equals(s)) {
            return true;
        }
        // 현재 문자열의 길이가 s보다 짧은 경우 더 이상 유효한 변환이 불가능
        if (current.length() < s.length()) {
            return false;
        }

        boolean result = false;

        // 마지막 문자가 'A'인 경우, 해당 문자를 제거하고 재귀 호출
        if (current.charAt(current.length() - 1) == 'A') {
            result = canTransform(current.substring(0, current.length() - 1));
            if (result) return true; // 결과가 참이면 바로 참 반환
        }

        // 첫 번째 문자가 'B'인 경우, 문자열을 뒤집고 첫 문자를 제거한 후 재귀 호출
        if (current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current.substring(1)).reverse().toString();
            result = canTransform(reversed);
            if (result) return true; // 결과가 참이면 바로 참 반환
        }

        return false;
    }
}
