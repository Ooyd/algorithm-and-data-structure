import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb  =new StringBuilder();
        
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append(c);
            }
        }
        System.out.println(sb);
        
        
    }
}