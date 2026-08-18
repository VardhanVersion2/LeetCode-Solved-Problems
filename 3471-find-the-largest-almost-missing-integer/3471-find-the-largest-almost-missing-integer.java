import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // Case 1: Subarray size equals array size
        if (k == n) {
            int maxVal = nums[0];
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }
        
        // Count frequencies of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // Case 2: Subarray size is 1
        if (k == 1) {
            int maxVal = -1;
            for (int num : nums) {
                if (count.get(num) == 1) {
                    maxVal = Math.max(maxVal, num);
                }
            }
            return maxVal;
        }
        
        // Case 3: 1 < k < n
        int ans = -1;
        if (count.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }
        if (count.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }
        
        return ans;
    }
}
