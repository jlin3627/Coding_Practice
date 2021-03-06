class Solution {
    public boolean canAttendMeetings(int[][] intervals) 
    {
        if (intervals.length <=1) return true;
        Arrays.sort(intervals,(a,b)->
                    {
                        if (a[0]!=b[0])return  a[0] - b[0];
                        return a[1] - b[1];
                    });
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] meet:intervals)
        {
            if (max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE)
            {
                if (max>meet[0]||min>meet[1]) 
                {
                    return false;
                }
                max = meet[1];
                min = meet[0];
            }
            else
            {
                max = meet[1];
                min = meet[0];
                
            }
        }
        return true;
    }
}