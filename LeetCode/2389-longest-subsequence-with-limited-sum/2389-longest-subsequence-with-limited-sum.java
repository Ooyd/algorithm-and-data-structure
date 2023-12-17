import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        if (nums.length == 0) {
            return new int[queries.length];
        }

        Arrays.sort(nums);
        int n = nums.length;

        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            answer[i] = findMaxSubsequenceSize(prefixSums, query);
        }
        return answer;
    }

    private int findMaxSubsequenceSize(int[] prefixSums, int query) {
        int left = 0, right = prefixSums.length - 1;
        int maxSize = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] <= query) {
                maxSize = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxSize;
    }
}
