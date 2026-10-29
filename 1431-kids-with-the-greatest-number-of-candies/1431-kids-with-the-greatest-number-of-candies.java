
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 1. Find the maximum number of candies any kid currently has
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;   ///CANDY SWAP HOGI CHHOTI WALI PAHLE WALI MAX MEIN ...
            }
        }
        
        List<Boolean> result = new ArrayList<>();  //CHECK....
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;  ///BOOL 
    }
}