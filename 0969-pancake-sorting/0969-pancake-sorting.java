import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
       
        for (int targetValue = arr.length; targetValue > 0; targetValue--) {
           
            int targetIndex = 0;
            while (arr[targetIndex] != targetValue) {
                targetIndex++;
            }

           
            if (targetIndex == targetValue - 1) {
                continue;
            }

    
            if (targetIndex != 0) {
                result.add(targetIndex + 1);
                flip(arr, targetIndex);
            }

            
            result.add(targetValue);
            flip(arr, targetValue - 1);
        }

        return result;
    }

    private void flip(int[] arr, int k) {
        int left = 0, right = k;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}