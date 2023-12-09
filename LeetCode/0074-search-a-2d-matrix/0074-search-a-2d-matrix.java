class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left =0, right = m * n -1;
        
        while(left <= right){
            int midIdx = left + (right - left) /2;
            int midElement = matrix[midIdx / n][midIdx % n];
            
            if(midElement == target){
                return true;
            }else if (midElement < target){
                left = midIdx + 1;
            }else if (midElement > target){
                right = midIdx - 1;
            }

            
        }
        
        return false;
    }
}