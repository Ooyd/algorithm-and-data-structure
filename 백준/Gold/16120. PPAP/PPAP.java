import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            st.push(currentChar);

            // 스택의 최근 4개 문자가 'PPAP'인지 확인
            if (st.size() >= 4) {
                char fourth = st.pop();
                char third = st.pop();
                char second = st.pop();
                char first = st.pop();

                if (first == 'P' && second == 'P' && third == 'A' && fourth == 'P') {
                    st.push('P');  // PPAP 패턴을 P로 축소
                } else {
                    // 원래 순서대로 다시 스택에 넣습니다.
                    st.push(first);
                    st.push(second);
                    st.push(third);
                    st.push(fourth);
                }
            }
        }

        // 스택에 P만 남아 있으면 PPAP 문자열
        if (st.size() == 1 && st.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
