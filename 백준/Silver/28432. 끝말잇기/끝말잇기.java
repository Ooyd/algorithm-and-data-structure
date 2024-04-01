import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //단어 목록 입력
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i =0; i<n; i++){
            words[i] = br.readLine();
        }
        
        //후보 단어 입력
        int m = Integer.parseInt(br.readLine());
        String[] candidates = new String[m];
        for(int i =0; i< m; i++){
            candidates[i] = br.readLine();
        }
            
        // ?의 앞 뒤 단어찾기
        String before = "", after = "";
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for(int i =0; i < n; i++){
            if(words[i].equals("?")){
                if (i > 0) before = words[i - 1];
                if (i < n - 1) after = words[i + 1];
                break;
            }
        }
        
        /**
         1. before 문자열이 존재하며  candidate의 첫번째문자와 같아야함.
         2. after 문자열이 존재하며 candidate의 마지막문자와 같아야함.
        **/
        for (String candidate : candidates) {
            if (!wordSet.contains(candidate) && //단어 반복 체크..
                (before.isEmpty() || before.charAt(before.length() - 1) == candidate.charAt(0)) &&
                (after.isEmpty() || candidate.charAt(candidate.length() - 1) == after.charAt(0))) {
                System.out.println(candidate);
                break;
            }
        }
        
    }
}