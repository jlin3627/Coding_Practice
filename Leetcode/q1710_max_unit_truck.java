class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->
        {
           if (a[1] > b[1]) return -1;
            else if (a[1] == b[1]) 
            {
                if (a[0] > b[0]) return -1;
                return 1;
            }
            return 1;
        });
        for (int[] t : boxTypes)
        {
            pq.add(t);
        }
        int ans = 0;
        while (truckSize>0 && pq.size()>0)
        {
            int[] t = pq.poll();
            if (truckSize - t[0] < 0) 
            {
                t[0] = truckSize;
            }
            ans+= t[0]*t[1];
            truckSize-=t[0];
        }
        return ans;
        
    }
}