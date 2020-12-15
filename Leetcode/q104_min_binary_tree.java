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
    public int maxDepth(TreeNode root) 
    {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<Pair<TreeNode, Integer>>();
        que.add(new Pair<TreeNode, Integer>(root,1));
        int ans = 1;
        while(!que.isEmpty())
        {
            Pair<TreeNode, Integer> test = que.poll();
            TreeNode tNode = test.getKey();
            ans = test.getValue();
            
            if (tNode.left!=null) que.add(new Pair<TreeNode, Integer>( tNode.left,ans+1));
            if (tNode.right!=null) que.add(new Pair<TreeNode, Integer>( tNode.right,ans+1));
        }
        return ans;
    }
}*/


/*class Solution {
    public int maxDepth(TreeNode root) 
    {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Integer>> que = new Stack<Pair<TreeNode, Integer>>();
        que.add(new Pair<TreeNode, Integer>(root,1));
        int ans = 1;
        int max = 1;
        while(!que.isEmpty())
        {
            Pair<TreeNode, Integer> test = que.pop();
            TreeNode tNode = test.getKey();
            ans = test.getValue();
            if (ans>max) max = ans;
            if (tNode.left!=null) que.add(new Pair<TreeNode, Integer>( tNode.left,ans+1));
            if (tNode.right!=null) que.add(new Pair<TreeNode, Integer>( tNode.right,ans+1));
        }
        return max;
    }
}*/

class Solution
{
    public int maxDepth(TreeNode root)
    {
        if (root == null) return 0;
        else
        {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}

/*
class Solution
{
    public int maxDepth(TreeNode root)
    {
        if (root == null) return 0;
        else
        {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}

class Solution
{
    public int maxDepth(TreeNode root)
    {
        if (root == null) return 0;
        else
        {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}

class Solution
{
    public int maxDepth(TreeNode root)
    {
        if (root == null) return 0;
        else
        {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}
*/ 
