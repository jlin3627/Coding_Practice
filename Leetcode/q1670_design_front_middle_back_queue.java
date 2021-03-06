/*
class FrontMiddleBackQueue 
{
    List<Integer> que;
    public FrontMiddleBackQueue() 
    {
        que = new LinkedList<Integer>();
    }
    
    public void pushFront(int val) 
    {
        que.add(0,val);    
    }
    
    public void pushMiddle(int val) 
    {
        que.add(que.size()/2,val); 
    }
    
    public void pushBack(int val) 
    {
        que.add(val);    
    }
    
    public int popFront() 
    {
        if (que.size()==0) return -1;
        int val = que.get(0);
        que.remove(0);
        return val;
    }
    
    public int popMiddle() 
    {
        System.out.println(que);
        if (que.size()==0) return -1;
        int mid = que.size()/2;
        if (que.size()%2 ==0) mid = que.size()/2-1;
        int val = que.get(mid);
        que.remove(mid);
        return val;
    }
    
    public int popBack() 
    {
        if (que.size()==0) return -1;
        int val = que.get(que.size()-1);
        que.remove(que.size()-1);
        return val;
    }
}

*/


class FrontMiddleBackQueue {

    Deque<Integer> front;
    Deque<Integer> back;
	// used size to avoid additional checks
    int size;
    
    public FrontMiddleBackQueue() {
        front = new LinkedList<>();
        back = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        front.addFirst(val);
        reBalance();
    }
    
    public void pushMiddle(int val) {
        front.addLast(val);
        reBalance();
    }
    
    public void pushBack(int val) {
        back.addLast(val);
        reBalance();
    }
    
    public int popFront() {
        if (isBothEmpty()) return -1;
        int value = front.isEmpty() ? back.pollFirst() : front.pollFirst();
        reBalance();
        return value;
    }
    
    public int popMiddle() {
        if (isBothEmpty()) return -1;
        int value = front.size() == back.size() ? front.pollLast() : back.pollFirst();
        reBalance();
        return value;
    }
    
    public int popBack() {
        if (isBothEmpty()) return -1;
        int value = back.isEmpty() ? front.pollLast() : back.pollLast();
        reBalance();
        return value;
        
    }
    // important part to rabalance queue
    private void reBalance() {
        if (front.size() > back.size()) {
            back.addFirst(front.pollLast());
            return;
        }
        if (front.size() < back.size() - 1) {
            front.addLast(back.pollFirst());
            return;
        }
    }
    
    private boolean isBothEmpty() {
        return front.isEmpty() && back.isEmpty();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */

class FrontMiddleBackQueue {
    ListNode dummyStart;
    ListNode dummyTail;
    ListNode mid;
    int size;

    public FrontMiddleBackQueue() {
        dummyStart = new ListNode(0);
        dummyTail = new ListNode(0);
        dummyStart.next = dummyTail;
        dummyTail.prev = dummyStart;
    }

    public void pushFront(int val) {
        ListNode newStart = new ListNode(val);
        newStart.next = dummyStart.next;
        newStart.prev = dummyStart;
        dummyStart.next.prev = newStart;
        dummyStart.next = newStart;
        size++;
        if (size == 1) {
            mid = newStart;
        } else {
            if (size % 2 == 0) {
                mid = mid.prev;
            }
        }
    }

    public void pushMiddle(int val) {
       if (size == 0) {
           ListNode newMid = new ListNode(val);
           newMid.prev = dummyStart;
           newMid.next = dummyTail;
           dummyStart.next = newMid;
           dummyTail.prev = newMid;
           mid = newMid;
           size++;
           return;
       }
        if (size % 2 == 0) {
            pushNext(val);
        } else {
            pushPrev(val);
        }
        size++;
    }

    private void pushPrev(int val) {
        ListNode newMid = new ListNode(val);
        newMid.next = mid;
        newMid.prev = mid.prev;
        newMid.prev.next = newMid;
        mid.prev = newMid;
        mid = newMid;
    }

    private void pushNext(int val) {
        ListNode newMid = new ListNode(val);
        newMid.next = mid.next;
        newMid.prev = mid;
        mid.next.prev = newMid;
        mid.next = newMid;
        mid = newMid;
    }

    public void pushBack(int val) {
        ListNode newEnd = new ListNode(val);
        newEnd.prev = dummyTail.prev;
        newEnd.next = dummyTail;
        dummyTail.prev.next = newEnd;
        dummyTail.prev = newEnd;
        size++;
        if (size == 1) {
            mid = newEnd;
        } else {
            if (size % 2 != 0) {
                mid = mid.next;
            }
        }
    }

    public int popFront() {
        if (size > 0) {
            ListNode next = dummyStart.next;
            removeNode(next);
            size--;
            if (size % 2 != 0) {
                mid = mid.next;
            }
            return next.val;
        }
        return -1;
    }

    private void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int popMiddle() {
        if (size > 0) {
            int val = mid.val;
            mid.next.prev = mid.prev;
            mid.prev.next = mid.next;
            if (size % 2 == 0) {
                mid = mid.next;
            } else {
                mid = mid.prev;
            }
            size--;
            return val;
        }
        return -1;
    }

    public int popBack() {
        if (size > 0) {
            ListNode prev = dummyTail.prev;
            removeNode(prev);
            size--;
            if (size % 2 == 0) {
                mid = mid.prev;
            }
            return prev.val;
        }
        return -1;
    }

    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }
}