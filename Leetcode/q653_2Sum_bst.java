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
/*class Solution 
{
    Set<Integer> st;
    public boolean findTarget(TreeNode root, int k) 
    {
        st = new HashSet<Integer>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while (que.peek()!=null)
        {
            TreeNode r = que.poll();
            st.add(r.val);
            if (r.val!=k-r.val&&st.contains(k-r.val)) return true;
            if (r.left!=null) que.offer(r.left);
            if (r.right!=null) que.offer(r.right);
        }
        for (int s:st)
        {
            if (s != k-s && st.contains(k-s)) return true;
        }
        return false;
    }
    
    public boolean search(TreeNode root, int k)
    {
        if (root == null) return false;
        
        if (root.val == k) return true;
        else if (root.val > k) return search(root.left, k);
        else // if (root.val>k)
        {
            return search(root.right,k);
        }
    }
}*/

/*public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
*/
/*public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
}*/

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

