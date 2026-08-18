class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap <Integer,Integer> map = new HashMap<>();
    int subArraySum =0;

    map.put(0,1);
    int count =0;

    for(int i =0 ; i<nums.length;i++)
    {
        subArraySum+=nums[i];
        int complement = subArraySum-k;
        if(map.containsKey(complement))
        {
        count+= map.get(complement);
        }

        map.put(subArraySum,map.getOrDefault(subArraySum,0)+1);
    } 

    return count;      
    }
}