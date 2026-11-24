    class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int nonZeroPos = 0; // Tracks where the next non-zero element should go

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                swap(nums[nonZeroPos], nums[i]);
                nonZeroPos++;
            }
        }
    }
};