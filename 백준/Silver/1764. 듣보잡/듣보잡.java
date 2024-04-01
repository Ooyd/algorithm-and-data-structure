import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        //듣도 못한 사람들 set 
        HashSet<String> notHeard = new HashSet<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            notHeard.add(s);
        }
            
        
        //보지 못한 사람들 set 기준점은 여기
        ArrayList<String> notSeenNotHeard = new ArrayList<>();
        for(int i =0; i<m; i++){
            String s = br.readLine();
            if(notHeard.contains(s)){
                notSeenNotHeard.add(s);
            }
        }
        Collections.sort(notSeenNotHeard); // 사전순 정렬
        System.out.println(notSeenNotHeard.size());
        for (String name : notSeenNotHeard) {
            System.out.println(name);
        }
        
    }
}