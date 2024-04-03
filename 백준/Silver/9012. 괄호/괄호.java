import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<T; i++){
            String data = br.readLine();
            System.out.println(solve(data) ? "YES" : "NO");
        }
    }
    
    private static boolean solve(String input) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: input.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            } else {
                System.out.println("(,) 예외의 문자는 입력할 수 없습니다.");
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}