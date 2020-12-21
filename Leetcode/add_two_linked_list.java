public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode ans = new ListNode();
        ListNode head;
        int rem = helper(ans, l1, l2);
        int n1 = 0;
        int n2 = 0;
        ListNode l1c = l1;
        ListNode l2c = l2;
        while(l1c!=null)
        {
            n1++;
            l1c = l1c.next;
        }
        
        while(l2c!=null)
        {
            n2++;
            l2c = l2c.next;
        }
        
        if (n1 > n2)
        {
            l1c = l1;
            while (n1>n2)
            {
                n1--;
                l1c = l1c.next;
            }
            int rem = helper(l1c,l2);
        }
        
        
        if (rem == 1) 
        {
            head = new ListNode(1);
            head.next = ans;
        }
        else
        {
            head = ans;
        }
        return head;
    }
    
    public int helper(ListNode ans, ListNode l1, ListNode l2, int l1pos, int l2pos)
    {
        int rem = 0;
        /*if (l1.next!=null && l2.next == null)
        {
            ans.next = new ListNode();
            rem = helper(ans.next,l1.next,l2,l1pos-1,l2pos);
        }
        else */if (l1.next!=null && l2.next != null)
        {
            ans.next = new ListNode();
            rem = helper(ans.next,l1.next,l2.next,l1pos+1,l2pos+1);
        }
        /*else if (l1.next!=null && l2.next != null)
        {
            ans.next = new ListNode();
            rem = helper(ans.next,l1,l2.next);
        }*/
        
        //if (l1.next == null && l2.next == null)
        //{
            System.out.print(l1.val);
            System.out.println(l2.val);
            ans.val = l1.val + l2.val + rem;
            //l1 = null;
            //l2 = null;
            if (ans.val%9 > 0)
            {
                ans.val = ans.val%9;
                rem = 1;
            }
        //}
        return rem;
        
    }