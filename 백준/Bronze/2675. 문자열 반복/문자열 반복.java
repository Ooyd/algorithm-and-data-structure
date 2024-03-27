import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i =0; i<n; i++){
            int r = sc.nextInt();
            String p = sc.next();
            
            StringBuilder sb = new StringBuilder();
            
            for(char c : p.toCharArray()){
                for(int j = 0; j<r; j++){
                    sb.append(c);
                }
            }
            
            System.out.println(sb);
        }
    }
}