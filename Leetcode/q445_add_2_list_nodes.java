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
/*class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            // keep the next node
            ListNode tmp = head.next;
            // reverse the link
            head.next = last;
            // update the last node and the current node
            last = head;
            head = tmp;    
        }    
        return last;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the current values 
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            
            // current sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }
}*/

/*class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // find the length of both lists
        int n1 = 0, n2 = 0;
        ListNode curr1 = l1, curr2 = l2;
        while (curr1 != null) {
            curr1 = curr1.next; 
            ++n1;    
        }
        while (curr2 != null) {
            curr2 = curr2.next; 
            ++n2;    
        }
            
        // parse both lists
        // and sum the corresponding positions 
        // without taking carry into account
        // 3->3->3 + 7->7 --> 3->10->10--> 10->10->3
        curr1 = l1; 
        curr2 = l2;
        ListNode head = null;
        while (n1 > 0 && n2 > 0) {
            int val = 0;
            if (n1 >= n2) {
                val += curr1.val; 
                curr1 = curr1.next; 
                --n1;    
            }
            if (n1 < n2) {
                val += curr2.val; 
                curr2 = curr2.next;
                --n2;    
            }
                
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;    
        }

        // take the carry into account
        // to have all elements to be less than 10
        // 10->10->3 --> 0->1->4 --> 4->1->0
        curr1 = head;
        head = null;
        int carry = 0;
        while (curr1 != null) {
            // current sum and carry
            int val = (curr1.val + carry) % 10;
            carry = (curr1.val + carry) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;

            // move to the next elements in the list
            curr1 = curr1.next;    
        }
        
        // add the last carry
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;    
        }

        return head;
    }
}*/

public class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}


/*
// build from back to front;
ListNode head = new ListNode(sum/10);
head.next = list;
list = head;

ListNode head = new ListNode(sum/10);
head.next = list;
list = head;

ListNode head = new ListNode(sum/10);
head.next = list;
list = head;

ListNode head = new ListNode();
head.next = list;
list = head;

ListNode head = new ListNode();
head.next = list;
list = head;

*/

/*
//build from front to back

ListNode ans = new ListNode();
ListNode haed = ans;
...
head.next = new ListNode();
head = head.next;

head.next = new ListNode();
head = head.next;

head.next = new ListNode();
head = head.next;

*/



/*class Solution
{
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry 
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }
}*/