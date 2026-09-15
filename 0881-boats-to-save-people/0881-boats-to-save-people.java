class Solution {
    public int numRescueBoats(int[] people, int limit) {
    
    Arrays.sort(people);
    int left =0;
    int right = people.length-1;
    int count=0;
    
    while(left <=  right) //same person!!!
    {
        int totalWeight = people[left]+people[right];

        if(totalWeight <= limit )
        {
         left++;
         right--;
         count++;
        }

        else
        {
            right--;
            count++;
        }
        
    }

     return count;
   }
}
    