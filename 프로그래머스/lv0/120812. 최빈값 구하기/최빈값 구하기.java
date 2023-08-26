import java.util.*;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) +1);
            } else {
                map.put(array[i], 1);
            }
        }
        
        int maxCount = 0;
        int maxValue = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxValue = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                maxValue = -1;
            }
        }
        return maxValue;


    }
}