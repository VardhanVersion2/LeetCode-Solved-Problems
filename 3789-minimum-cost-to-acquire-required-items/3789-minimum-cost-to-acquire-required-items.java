class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
         long common = Math.min(need1, need2);
        
        
         long effectiveBoths = Math.min((long) costBoth, (long) cost1 + cost2);
        long totalCost = common * effectiveBoths;
        
        long remain1 = need1 - common;
         long remain2 = need2 - common;
        
      
           if (remain1 > 0) {
            totalCost += remain1 * Math.min((long) costBoth, (long) cost1);
        }
        
        if (remain2 > 0) {
            totalCost += remain2 * Math.min((long) costBoth, (long) cost2);
        }
        
        return totalCost;
    }
}