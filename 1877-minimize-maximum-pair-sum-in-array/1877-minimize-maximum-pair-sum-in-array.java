class Solution {
    public int minPairSum(int[] nums) {
    //sorted...
    Arrays.sort(nums);
    //initiated variables...
    int left = 0 , right = nums.length-1;
    int maxSum = 0;
    int sum =0;
    //loop starts...
    while(left < right )
    { 
        //base case...
        sum = nums[left]+nums[right];
        maxSum = Math.max(maxSum , sum ); // validator...
        right--;
        left++;
        }
         
    return maxSum; //final return..
    }
}