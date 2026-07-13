import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Loop through all possible starting digits 1 to 9
        for (int i = 1; i <= 9; i++) {
            int num = i;
            int nextDigit = i + 1;
            
            // Keep appending the next sequential digit
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                nextDigit++;
                
                // Add to result if it falls within the range
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        // Sort the result as the generation order is not strictly ascending
        Collections.sort(result);
        return result;
    }
}
