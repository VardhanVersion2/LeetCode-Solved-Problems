import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        // Record reserved seats using bitmasks for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
        }
        
        // Empty rows can accommodate 2 four-person groups each
        int maxGroups = (n - rowMasks.size()) * 2;
        
        // Evaluate remaining rows with reserved seats
        for (int mask : rowMasks.values()) {
            boolean leftFree = (mask & 60) == 0;    // Seats 2, 3, 4, 5 (0b0000111100)
            boolean rightFree = (mask & 960) == 0;  // Seats 6, 7, 8, 9 (0b0111100000)
            boolean midFree = (mask & 240) == 0;    // Seats 4, 5, 6, 7 (0b0001111000)
            
            if (leftFree && rightFree) {
                maxGroups += 2;
            } else if (leftFree || rightFree || midFree) {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}