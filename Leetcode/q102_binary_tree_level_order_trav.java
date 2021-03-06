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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        if (root == null) return new LinkedList<List<Integer>>();
        Queue<Pair<TreeNode,Integer>> que = new LinkedList<Pair<TreeNode,Integer>>();
        que.add(new Pair(root, 1));
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        while (!que.isEmpty())
        {
            Pair<TreeNode, Integer> test = que.poll();
            TreeNode node = test.getKey();
            int val = test.getValue();
            if ( ans.size() < val  ) ans.add(new LinkedList<Integer>());
            ans.get(val-1).add(node.val);
            if (node.left!=null) que.add(new Pair(node.left, val+1));
            if (node.right!=null) que.add(new Pair(node.right, val+1));
        }
        return ans;
    }
}*/


class Solution
{
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public void helper(TreeNode node, int level)
    {
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());
        
        levels.get(level).add(node.val);
        
        if (node.left!=null)
        {
            helper(node.left, level+1);
        }
        if(node.right!=null)
        {
            helper(node.right, level+1);
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}