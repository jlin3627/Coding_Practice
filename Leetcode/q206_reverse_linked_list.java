/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
class Solution {
    public ListNode reverseList(ListNode head) 
    {
        if (head == null) return head;
        Stack<Integer> st = new Stack<>();
        ListNode ans = new ListNode();
        ListNode ansHead = ans;
        while(head!=null)
        {
            st.push(head.val);
            head = head.next;
        }
        while(!st.isEmpty())
        {
            ans.val = st.pop();
            if (!st.isEmpty())
            {
                ans.next = new ListNode();
                ans = ans.next;
            }
           
        }
        return ansHead;
    }
}*/


/*
class Solution 
{
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}*/
class Solution
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}




class Solution
{
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr =head;
        while (curr!=null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

class Solution
{
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr =head;
        while (curr!=null)
        {
            ListNode nextTemp = curr.next;
            curr.next =prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

class Solution
{
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev= curr;
            curr = nextTemp;
        }
        return prev;
    }

}