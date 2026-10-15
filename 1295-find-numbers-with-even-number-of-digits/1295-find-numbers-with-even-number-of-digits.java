class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitCount = 0;
            
           
            if (num == 0) {
                digitCount = 1;

            } else {
                while (num > 0) {
                    digitCount++;
                    num /= 10;
                }
            }
            
    
            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }
        
        return evenCount;
    }
}