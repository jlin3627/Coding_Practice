class Solution {
    public int[][] kClosest(int[][] points, int K) 
    {
        int[] origin = new int[2];
        origin[0] = 0;
        origin[1] = 0;
        Queue<Pair<int[],Double>> test = 
            new PriorityQueue<Pair<int[],Double>> 
            ( 
                (p1,p2) ->
                { return (int)(p1.getValue()*100 - p2.getValue()*100); }
        );
        for (int[] pt:points)
        {
            test.add(new Pair(pt, dist(pt,origin)));
        }
        
        int[][] ans = new int[K][2];
        for (int i = 0; i<K; i++)
        {
             ans[i] = test.poll().getKey();
        }
        return ans;
    }
    
    double dist(int[] pt1, int[] pt2)
    {
        return Math.sqrt(Math.pow(Math.abs(pt1[0]-pt2[0]),2) + Math.pow(Math.abs(pt1[1]-pt2[1]),2));
    }
}