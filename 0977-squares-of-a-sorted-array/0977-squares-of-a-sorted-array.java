class Solution {
    public int[] sortedSquares(int[] nums) {

    int left =0;
    int right = nums.length-1;
    int pos = nums.length -1;

    int ans[] = new int[nums.length];

    while(left <= right)
    {
        int leftSq = nums[left]*nums[left];
        int rightSq = nums[right]*nums[right];

        if(leftSq>rightSq)
        {
          ans[pos] = leftSq;
          left++;
        }

        else
        {
          ans[pos] = rightSq;
          right--;
        }

        pos--;
    }

    return ans; 
    }
}