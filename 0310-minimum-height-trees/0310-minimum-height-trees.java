import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Edge case: if there's only one node, it's the root of the MHT
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Step 1: Initialize the adjacency list and tracking for node degrees
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // Step 2: Initialize the first layer of leaves (nodes with degree == 1)
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }

        // Step 3: Trim the leaves until we have 2 or fewer nodes left
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leavesSize = leaves.size();
            remainingNodes -= leavesSize; // Deduct the current layer of leaves
            
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                
                // Find the neighbor of this leaf and remove the connection
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    // If the neighbor becomes a leaf, add it to the next layer
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        // The remaining nodes in the queue are the centroids/roots of MHTs
        return new ArrayList<>(leaves);
    }
}