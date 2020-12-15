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
/*

class Solution {
    public int kthSmallest(TreeNode root, int k) 
    {
        int ans = 0;
        if (root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        while (root!=null || !st.isEmpty())
        {
            while (root!=null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }
}*/

/*class Solution
{
    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> arr)
    {
        if (root == null) return arr;
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
        return arr;
    }
    
    public int kthSmallest(TreeNode root, int k)
    {
        ArrayList<Integer> nums = dfs(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }
}*/


