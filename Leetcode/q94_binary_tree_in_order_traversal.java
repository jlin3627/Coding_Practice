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
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new LinkedList<Integer>();
        
        if (root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        while (root!=null || !st.isEmpty())
        {
            while (root != null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}*/

class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new LinkedList<>();
        dfsInOrder(root, ans);
        return ans;
    }
    
    public void dfsInOrder(TreeNode root, List<Integer> lst)
    {
        if (root!=null)
        {
            if (root.left!=null)
            {
                dfsInOrder(root.left, lst);
            }
            lst.add(root.val);
            if (root.right!=null) 
            {
                dfsInOrder(root.right, lst);
            }
        }
    }
}