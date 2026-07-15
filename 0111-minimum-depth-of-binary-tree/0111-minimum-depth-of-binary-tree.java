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
    public int minDepth(TreeNode root) {
    //important-variables...

   int  minDepthR = 0;
   int minDepthL = 0;


    int minSum = Integer.MAX_VALUE;

    if(root == null)
    {
        return 0; //agr tree hi nhi hai  ...
    }

    if(root.left == null && root.right == null)
    {
        return 1; // tree ka ek hi node hai jo leaf bhi hai...
    }

    minDepthL =  minDepth(root.left) +1;
    minDepthR =  minDepth(root.right) +1; 
    if(root.right== null)
    {
        return minDepthL;//key
    }

    if(root.left == null)
    {
       return minDepthR;  
    }

    minSum = Math.min(minDepthL , minDepthR );

    return minSum;
    
    }
 
}
