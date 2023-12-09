import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(read.readLine());
        Stack<Integer> st = new Stack();
        int result = 0;
        for (int i = 0 ; i < n; i++){
            int keyword = Integer.parseInt(read.readLine());
            if (keyword == 0){
                st.pop();
            } else {
                st.add(keyword);
            }
        }
        
        while(!st.isEmpty()){
            result += st.pop();
        }
        System.out.println(result);
        
    }
}