import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();

        for(int i : arr){
            if(st.isEmpty() || st.peek() != i){
                st.push(i);
            }
        }
        
        int[] answer = new int[st.size()];        
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = st.get(i);
        }
        return answer;
    }
}

