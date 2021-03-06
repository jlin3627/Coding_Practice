import java.util.Stack;

class dfs
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    // In Order
    // recursive
    public void dfsInOrder(TreeNode node)
    {
        if (node.left!=null) dfsInOrder(node.left);
        System.out.println(node.val);
        if (node.right!=null) dfsInOrder(node.right);
    }

    // iterative
    public void dfsInOrder(TreeNode node)
    {
        if (node == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = node;

        while (curr!=null || st.size()>0)
        {
            while (curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.println(curr.val);

            curr = curr.right;
        }
    }

    // Pre Order
    // recursive
    public void dfsPreOrder(TreeNode node)
    {
        System.out.println(node.val);
        if (node.left!=null) dfsInOrder(node.left);
        if (node.right!=null) dfsInOrder(node.right);
    }

    // iterative O(N);
    public void dfsInOrder(TreeNode node)
    {
        if (node == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = node;
        st.push(node);

        while (st.size()>0)
        {
            curr = st.pop();
            System.out.println(curr.val);

            if (curr.right!=null)
            {
                st.push(curr.right);
            }
            if(curr.left!=null)
            {
                st.push(curr.left);
            }
        }
    }
    // iterative O(H)
    public void dfsInOrder(TreeNode node)
    {
        if (node == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = node;

        while (curr != null || !st.isEmpty())
        {
            while(curr!=null)
            {
                System.out.println(curr.val);
                if (curr.right!=null)
                {
                    st.push(curr.right);
                }
                curr = curr.left;
            }

            if (!st.empty())
            {
                curr = st.pop();
            }
        }
    }

    // Pre Order
    // recursive
    public void dfsPostOrder(TreeNode node)
    {
        if (node.left!=null) dfsInOrder(node.left);
        if (node.right!=null) dfsInOrder(node.right);
        System.out.println(node.val);
    }

    // iterative
    // https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
    public void dfsPostOrder(TreeNode node)
    {
        if (node == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(node);
        TreeNode prev = null; 
        /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
                    
        
        while (!st.isEmpty())
        {
            TreeNode curr = st.peek();
            if (prev == null || prev.left == curr || prev.right == curr)
            {
                if (curr.left!=null) st.push(curr.left);
                else if (curr.right!=null) st.push(curr.right);
                else
                {
                    System.out.println(st.pop().val);
                }
                /* go up the tree from left node, if the child is right 
                push it onto stack otherwise process parent and pop 
                stack */
            }
            else if (curr.left == prev)
            {
                if (curr.right!=null) st.push(curr.right);
                else
                {
                    System.out.println(st.pop().val);
                }
                /* go up the tree from right node and after coming back 
                from right node process parent and pop stack */
            }
            else if (curr.right == prev)
            {
                System.out.println(st.pop().val);
            }

            prev = curr;
        }
    }


    // post order
    // https://www.geeksforgeeks.org/iterative-postorder-traversal/
    public void dfsPostOrder(TreeNode node)
    {
        Stack<TreeNode> s1, s2; 
  
        s1 = new Stack<>(); 
         s2 = new Stack<>(); 
      
        if (node == null) 
            return; 
    
        // push root to first stack 
        s1.push(node); 
    
        // Run while first stack is not empty 
        while (!s1.isEmpty()) 
        { 
            // Pop an item from s1 and push it to s2 
            TreeNode temp = s1.pop(); 
            s2.push(temp); 
    
            // Push left and right children of 
            // removed item to s1 
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
    
        // Print all elements of second stack 
        while (!s2.isEmpty()) 
        { 
            node temp = s2.pop(); 
            System.out.print(temp.data + " "); 
        } 

    }
}