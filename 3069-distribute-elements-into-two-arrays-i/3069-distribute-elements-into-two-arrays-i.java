

class Solution {
    public int[] resultArray(int[] nums) {
        // Core state holders using List containers
        List<Integer> arr1 = new ArrayList<>(List.of(nums[0]));
        List<Integer> arr2 = new ArrayList<>(List.of(nums[1]));

        // Use a functional pipeline to process elements from index 2 onwards
        java.util.stream.IntStream.range(2, nums.length)
            .map(i -> nums[i])
            .forEach(val -> {
                if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                    arr1.add(val);
                } else {
                    arr2.add(val);
                }
            });

        // Functional concatenation and conversion to primitive int[] array
        return Stream.concat(arr1.stream(), arr2.stream())
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
