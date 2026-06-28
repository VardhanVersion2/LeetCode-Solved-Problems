class Solution {
    public int maxProfit(int[] prices) {
       int  minDay= prices[0];
       int maxProfit = Integer.MIN_VALUE;
       int profit =0;
       for(int i =1 ; i<prices.length ; i++)
       {
         profit = prices[i]-minDay;
         maxProfit = Math.max(maxProfit , profit);
         minDay = Math.min(minDay,prices[i]);
       }
        
        if(maxProfit<0)
        {
            return 0;
        }
       return maxProfit;
    }
}