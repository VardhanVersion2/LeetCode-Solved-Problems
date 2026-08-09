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

    if(root == null)
    {
        return 0;
    }
    int maxHeightL = maxDepth(root.left);
    int maxHeightR = maxDepth(root.right);

    int maximumNodeDepth = Math.max( maxHeightL+1 , maxHeightR+1 );
    
    return maximumNodeDepth;


        
    }
}