
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Keep a Min-Heap of size K based on frequencies
        // We compare the map values (frequencies) to keep the highest ones
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            heap.add(num);
            // If the heap grows larger than k, remove the least frequent element
            if (heap.size() > k) {
                heap.poll(); 
            }
        }

        // Step 3: Build the final output array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
