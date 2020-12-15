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
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if (nums.length == 0 || nums == null) return null;
        TreeNode ans = bst(nums, 0, nums.length-1);
        return ans;
    }
    
    public TreeNode bst(int[] nums, int l, int r)
    {
        if (l>r) return null;
        int mid = l + ((r-l) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums,l,mid-1);
        root.right = bst(nums,mid+1,r);
        return root;
        
    }
}

/*
class Solution {
  int[] nums;

  public TreeNode helper(int left, int right) {
    if (left > right) return null;

    // always choose left middle node as a root
    int p = (left + right) / 2;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[p]);
    root.left = helper(left, p - 1);
    root.right = helper(p + 1, right);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }
}
*/
/*
class Solution {
  int[] nums;

  public TreeNode helper(int left, int right) {
    if (left > right) return null;

    // always choose right middle node as a root
    int p = (left + right) / 2;
    if ((left + right) % 2 == 1) ++p;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[p]);
    root.left = helper(left, p - 1);
    root.right = helper(p + 1, right);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }
}
*/

/*

class Solution {
    int[] nums;
    Random rand = new Random();
    
    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        
        // choose random middle node as a root
        int p = (left + right) / 2; 
        if ((left + right) % 2 == 1) p += rand.nextInt(2);

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);    
    }
}
*/


/*
practice
class Solution
{
    int[] _nums;
    public TreeNode sortedArrayToBST(int[] nums)
    {
        this._nums = nums;
        if (nums.length == 0 || nums == null) return null;
        
        return dfs(0, nums.length-1);
    }
    
    public TreeNode dfs(int l, int r)
    {
        if (l>r) return null;
        int mid = l + ((r-l) / 2);
        TreeNode root = new TreeNode(this._nums[mid]);
        root.left = dfs(l, mid - 1);
        root.right =dfs(mid+1, r);
        return root;
    }
}

class Solution
{
    int[] _nums;
    public TreeNode sortedArrayToBST(int[] nums)
    {
        this._nums = nums;
        if (nums.length == 0 || nums == null) return null;
        return dfs(0, nums.length-1);
    }

    public TreeNode dfs(int l, int r)
    {
        if (l>r) return null;
        int mid = l + ((r-l) / 2);
        TreeNode root = new TreeNode(this._nums[mid]);
        root.left = dfs(l, mid -1);
        root.right = dfs(mid+1, r)
        returm root;
    }
}

class Solution
{
    int[] _nums;
    public TreeNode sortedArrayToBST(int[] nums)
    {
        this._nums = nums;
        if (nums.length == 0 || nums == null) return null;
        return dfs(0, nums.length - 1);
    }

    public TreeNode dfs(int l, int r)
    {
        if (l>r) return null;
        int mid = l+ (r-l)/2;
        TreeNode root = new TreeNode(this._nums[mid]);
        root.left = dfs(l, mid-1);
        root.right = dfs(mid++1, r);
        return root;
    }
}


*/ 