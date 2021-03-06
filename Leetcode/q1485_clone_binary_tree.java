/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

/*class Solution 
{
    NodeCopy start;
    public NodeCopy copyRandomBinaryTree(Node root) 
    {
        if (root == null) return null;
        NodeCopy head = new NodeCopy();
        NodeCopy ans = head;
        start = head;
        head.val = root.val;
        head.left = copyRandomBinaryTree(root.left);
        head.right = copyRandomBinaryTree(root.right);
        if (root.random == null) head.random = null;
        else
        {
            head.random = dfs(start,root.random);
        }
        
        return ans;
    }
    
    private NodeCopy dfs(NodeCopy head, Node root)
    {
        NodeCopy ans;
        if (head == null) return null;
        if (head.val == root.val )
        {
            ans = head;
            return ans;
        }
        if (head.left!=null) 
        {
            ans = dfs(head.left,root);
            if (ans!=null) return ans;
        }
        if (head.right!=null)
        {
            ans = dfs(head.right,root);
            if(ans!=null) return ans;
        }
        return null;
    }
}*/

class Solution
{
    Map<Node, NodeCopy> mp;
    
    public NodeCopy copyRandomBinaryTree(Node root)
    {
        mp = new HashMap<Node,NodeCopy>();
        if (root == null) return null;
        return dfs(root);
    }
    
    public NodeCopy dfs(Node cur)
    {
        if (cur == null) return null;
        if(mp.containsKey(cur)) return mp.get(cur);
        NodeCopy node = new NodeCopy(cur.val);
        mp.put(cur,node);
        node.left = dfs(cur.left);
        node.right = dfs(cur.right);
        node.random = dfs(cur.random);
        return node;
        
    }
}

