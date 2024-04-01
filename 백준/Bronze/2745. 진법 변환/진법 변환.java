import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        
        int result = 0;
        for(int i =0; i<N.length(); i++){
            int num = charToNumber(N.charAt(i));
            result = result * B + num;
        }
        
        System.out.println(result);
    }
    
    public static int charToNumber(char ch){
        if(ch > '0' && ch <= '9'){
            return ch - '0';
        } else if(ch >='A' && ch <= 'Z'){
            return 10 + ch -'A';
        } 
        return 0;
    }
}