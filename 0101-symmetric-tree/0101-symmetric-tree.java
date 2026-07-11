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
    public boolean isSymmetric(TreeNode root) {
    
    Queue <TreeNode> q = new LinkedList<>();

    if(root == null)
    {
        return true;
    }

    q.add(root.left); //<--//do alag alag stream bn gayi
    q.add(root.right); 

    //roots are initiated , start engine...

    while(!q.isEmpty())
    {
        TreeNode p = q.poll();   //<-- do nodes 1.
        TreeNode qNode = q.poll(); //2.

        if(p==null && qNode==null) //conditions...
        {
            continue;
        }

        if(p==null || qNode==null)
        {
            return false;
        }

        if(p.val != qNode.val)
        {
            return false;
        }

        q.add(p.left); //---> Manager Queue 1.
        q.add(qNode.right);//---> Manager Queue 2.

        q.add(p.right); //---> Manager Queue 1.
        q.add(qNode.left);//---> Manager Queue 2.  

    }
 return true;
    }
}