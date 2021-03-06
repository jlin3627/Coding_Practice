/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    private int min;
    private TreeNode ans;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        min = Integer.MAX_VALUE;
        findNext(root,p.val);
        return min == Integer.MAX_VALUE? null:ans;
    }
    private void findNext(TreeNode root, int val)
    {
        if (root == null) return;
        if (root.val>val && root.val<min)
        {
            min = root.val;
            ans = root;
        }
        findNext(root.left, val);
        findNext(root.right,val);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // BST O(h) = O(log n).
class Solution 
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        TreeNode ans = null;
        TreeNode cur = root;
        while (cur != null)
        {
            if (cur.val > p.val)
            {
                ans = cur;
                cur = cur.left;
            }
            else
            {
                cur = cur.right;
            }
        }
        return ans;
    }
}