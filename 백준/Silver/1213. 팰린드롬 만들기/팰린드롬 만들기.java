import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] charCount = new int[26];
        // 문자열에서 각 문자의 빈도수를 센다.
        for (char c : input.toCharArray()) {
            charCount[c - 'A']++;
        }

        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) oddCount++;
        }

        // 팰린드롬을 만들 수 없는 조건 검사
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder palindrome = new StringBuilder();
            char oddChar = 0;
            // 팰린드롬의 절반을 만든다.
            for (int i = 0; i < 26; i++) {
                if (charCount[i] % 2 != 0) {
                    oddChar = (char) (i + 'A');
                }
                for (int j = 0; j < charCount[i] / 2; j++) {
                    palindrome.append((char) (i + 'A'));
                }
            }
            // 가운데에 홀수 빈도의 문자를 추가한다(있는 경우).
            String middle = oddChar != 0 ? String.valueOf(oddChar) : "";
            // 팰린드롬의 나머지 절반을 거울처럼 만들어 완성한다.
            String result = palindrome.toString() + middle + palindrome.reverse().toString();
            System.out.println(result);
        }
    }
}
