import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int res = 0;
        String input = br.readLine();
        for (int i=0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else{
                if(input.charAt(i -1 ) == '('){
                    stack.pop();
                    res += stack.size();
                } else {
                    stack.pop();
                    res++;
                }
            }
        }
        
        System.out.println(res);
        
    }
}