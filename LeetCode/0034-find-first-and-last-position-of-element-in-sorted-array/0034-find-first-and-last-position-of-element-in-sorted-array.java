class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1; //use for Binary Search
        int start = -1, end = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                start = mid;
                high = mid - 1; // 왼쪽 부분 탐색
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                end = mid;
                low = mid + 1; // 오른쪽 부분 탐색
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] {start,end};

        
    }
}