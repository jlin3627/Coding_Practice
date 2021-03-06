/*
class Solution 
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if (l1 == null && l2==null) return null;
        ListNode t = new ListNode();
        ListNode head = t;
        
        while (l1!=null && l2!=null)
        {
            t.next = new ListNode();
            t = t.next;
            if (l1.val<l2.val)
            {
                t.val = l1.val;
                
                l1 = l1.next;
            }
            else if (l2.val<l1.val)
            {
                t.val = l2.val;
                l2 = l2.next;
            }
            else
            {
                t.val = l1.val;
                t.next = new ListNode();
                t = t.next;
                t.val = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (l1 == null && l2 == null) t = null;
        if (l1!=null)
        {
            t.next = new ListNode();
            t = t.next;
            t.val = l1.val;
            t.next = l1.next;
        }
        if (l2!=null)
        {
            t.next = new ListNode();
            t = t.next;
            t.val = l2.val;
            t.next = l2.next;
        }
        return head.next;
    }
}
*/


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

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode ans = new ListNode();
        ListNode head = ans;
        while (l1!= null && l2!=null)
        {
            if(l1.val <= l2.val)
            {
                ans.next = l1;
                l1 = l1.next;
            }
            else
            {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l2!= null)
        {
            ans.next = l2;
        }
        else if (l1!= null)
        {
            ans.next = l1;
        }
        return head.next;
    }
}

