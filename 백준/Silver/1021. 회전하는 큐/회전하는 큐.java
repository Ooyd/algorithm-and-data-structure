import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
    	    int m = Integer.parseInt(st.nextToken());
            
            LinkedList<Integer> deque = new LinkedList<Integer>();
    	
    	    int count = 0;
    	
    	    for(int i = 1; i <= n; i++) {
    		    deque.offer(i);
            }
            int[] arr = new int[m];
    	
    	    st = new StringTokenizer(br.readLine());
    	
    	    for(int i = 0; i < m; i++) {
    	    	arr[i] = Integer.parseInt(st.nextToken());
    	    }
            
            for(int i = 0; i < m; i++) {
    		
    		    int idx = deque.indexOf(arr[i]);
    		
    		    int half_idx;
    		
    		    if(deque.size() % 2 == 0) {
    			    half_idx = deque.size() / 2 - 1;
    		    } else {
    		    	half_idx = deque.size() / 2;
    		    }
    		
    		    // 원소가 중간 지점보다 앞에 있거나 중간 지점에 있을 경우
    	    	// 2번 연산 수행
    	    	if(idx <= half_idx) {
    			
    	    		for(int j = 0; j < idx; j++) {
    	    			int num = deque.pollFirst();
    		    		deque.offerLast(num);
    			    	count++;
    			    }
    			
    		    } else {
    		    // 원소가 중간 지점보다 뒤에 있는 경우 (3번 연산 수행)	
    		    	for(int j = 0; j < deque.size() - idx; j++) {
    		    		int num = deque.pollLast();
    		    		deque.offerFirst(num);
    		    		count++;
    		    	}
    			
    		}
    		deque.pollFirst();
    	}
            
        System.out.println(count);
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}