import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> remainderMap = new HashMap<>();
    
        remainderMap.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;

            if (remainderMap.containsKey(remainder)) {
            
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
            
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}