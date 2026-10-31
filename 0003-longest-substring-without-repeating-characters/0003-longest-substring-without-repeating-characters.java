class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet <Integer> set = new HashSet<>();
        char c[] = s.toCharArray();

        int maxLength =0;

        if(c.length ==0)
        {
            return 0;
        }

        for(int i =0 ; i<c.length ; i++)
        {
            int lengthCount=0;
            if(!set.contains(c[i-1]))
            {
              lengthCount++;
            }
            else
            {
                return 1;
            }
            
            set.add(c[i]);
            maxLength = Math.max(maxLength, lengthCount);
        }

        return maxLength;
    
        
    }
}