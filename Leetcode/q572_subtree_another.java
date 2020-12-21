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
    public boolean isSubtree(TreeNode s, TreeNode t) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        boolean ans = false;
        while (!queue.isEmpty())
        {
            TreeNode test = queue.poll();
            //System.out.println(test.val);
            ans = help(test,t);
            
            if (ans)
            {
                
                return true;
            }
            if (test.left!=null) queue.offer(test.left);
            if (test.right!=null) queue.offer(test.right);
        }
       return false;
    }
    public boolean help(TreeNode s, TreeNode t)
    {
        boolean check = false;
        if (s==null && t!=null || s!=null && t == null) return false;
        if (s==null && t== null) return true;
        if (s.val == t.val) check = help(s.left,t.left) && help(s.right,t.right);
        return check;
    }
}