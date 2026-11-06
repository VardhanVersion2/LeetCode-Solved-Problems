class Solution {
    public boolean isPalindrome(int x) {

     int reversedNum =0;
     int original =x;
      while (x > 0) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }

        if(reversedNum != original)
        {
            return false;
        }
        else
        {
            return true;
        }

        
    }
}