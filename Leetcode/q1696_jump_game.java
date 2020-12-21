	/*class Solution 
    {
		public int maxResult(int[] nums, int k) 
		{
			int ind=0;
			int n=nums.length;
			int ans=nums[0];
			while(ind!=n-1)
			{
				int next=ind+1;
				boolean find = false;;
				for(int i=1;i<=k;i++)
				{
					if(ind+i<n)
					{
						if(nums[ind+i]>nums[next])next=ind+i;
						if(nums[ind+i]>=0||ind+i==n-1)
						{
							ans+=nums[i+ind];
							ind=ind+i;
							find = true;
							break;
						}
					}
				}
				if(!find)
				{
					ans+=nums[next];
					ind=next;
				}
			}
			return ans;
		}
	}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        //strategy: Bottom Up DP
        int n = nums.length;
        int[] dp = new int[n];
        //always start at 0th index so largest curr sum is nums[0]
        dp[0] = nums[0];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            //remove the sums outside of the curr range
            
            while (q.size() >= k) {
                q.poll();
            }
            //remove the sums that are smaller than previous cell
            while (!q.isEmpty() && dp[q.peek()] < dp[i - 1]) 
            {
                q.poll();
            }
            //add to q 
           
            q.add(i - 1);
            
            
            //the first number is the biggest within the range
            dp[i] = nums[i] + dp[q.peek()];
            
            
        }
        return dp[n-1];
    }
}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{n - 1, nums[n - 1]});
        for (int i = n - 2; i >= 0; i--){
            while(pq.peek()[0] > i + k){
                pq.poll();
            }
            ans = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, ans});
        }
        
        return ans;
    }
}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        //strategy: Sliding Window
        int n = nums.length, max = nums[0];
        //sort by descending sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //add max and pos to pq
        pq.add(new int[]{max, 0});
        for (int i = 1; i < n; i++) {
            //remove sums that outside of the range
            while (pq.peek()[1] < i - k) {
                pq.poll();
            }
            //find new max
            max = nums[i] + pq.peek()[0];
            //add curr max and pos to pq
            pq.add(new int[]{max, i});
        }
        return max;
    }
}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peek()] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }
}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] { 0, score });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst()[0] < i - k) {
                dq.pollFirst();
            }
            score = dq.peek()[1] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score >= dq.peekLast()[1]) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { i, score });
        }
        return score;
    }
}*/

/*class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.remove();
            }
            score[i] = nums[i] + score[priorityQueue.peek()[1]];
            priorityQueue.add(new int[] { score[i], i });
        }
        return score[n - 1];
    }
}*/

class Solution 
{
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.remove();
            }
            score = nums[i] + priorityQueue.peek()[0];
            priorityQueue.add(new int[] { score, i });
        }
        return score;
    }
}

