import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++){
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int start = 1;         
        
        while(!q.isEmpty()){
            int watingList = q.poll();
            if(watingList == start){
                start++;
                while(!s.isEmpty() && s.peek() == start){
                    s.pop();
                    start++;
                }
            } else{
                s.push(watingList);
            }
        }
                        
        while(!s.isEmpty() && s.peek() == start){
            s.pop();
            start++;
        }
                        
                        
        System.out.println(s.isEmpty()? "Nice" : "Sad");
    }
}