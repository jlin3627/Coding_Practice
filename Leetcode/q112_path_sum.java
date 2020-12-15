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
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        if (root == null ) return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair(root, sum));
        
        while ( !stack.isEmpty() )
        {
            Pair<TreeNode, Integer> test = stack.pop();
            TreeNode rt = test.getKey();
            int     iAns = test.getValue();
            //System.out.println(rt.val);
            if (rt.left == null && rt.right == null && rt.val == iAns) return true;
            if (rt.left!=null ) stack.push(new Pair(rt.left, iAns-rt.val));
            if (rt.right!=null) stack.push(new Pair(rt.right, iAns-rt.val));
        }
        return false;
    }
}*/

class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) return true;
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
    }
}

/*
class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) return true;

        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}


class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        sum-= root.val;
        if (root.left == null && root.right == null && sum == 0 ) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root. right == null && sum ==0 ) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
*/ 