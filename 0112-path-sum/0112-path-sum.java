class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. Base case: If the node is null, no path exists
        if (root == null) {
            return false;
        }

        // 2. Subtract the current node's value from our target
        targetSum -= root.val;

        // 3. Check if we hit a leaf node (no left or right child)
        if (root.left == null && root.right == null) {
            // If targetSum is now 0, we found a valid path!
            return targetSum == 0;
        }

        // 4. Recurse down both sides. If EITHER side finds a path (true), return true.
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
