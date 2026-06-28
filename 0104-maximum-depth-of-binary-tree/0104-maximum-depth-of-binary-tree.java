/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    int maxTreeDepth = 0; 

    if(root == null)
    {
        return 0;
    }     

    int maxL = maxDepth(root.left);
    int maxR = maxDepth(root.right);



    maxTreeDepth = Math.max(maxL,maxR)+1;

    return maxTreeDepth;
    }
}