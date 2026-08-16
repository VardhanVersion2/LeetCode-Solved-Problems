class Solution {
    public boolean stoneGameIX(int[] stones) {
        // Step 1: Count stones by their remainders when divided by 3
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        
        // Step 2: Determine winner based on the parity of type-0 stones
        if (cnt[0] % 2 == 0) {
            // Even zeros: Alice needs at least one of both type-1 and type-2 stones
            return cnt[1] > 0 && cnt[2] > 0;
        } else {
            // Odd zeros: Alice needs a distinct difference of more than 2 between type-1 and type-2
            return Math.abs(cnt[1] - cnt[2]) > 2;
        }
    }
}
