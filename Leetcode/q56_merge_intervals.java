class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        for (int i = 0 ;i <intervals.length; i++)
        {
            int[] test = intervals[i];
            if (lst.size() == 0)
            {
                List<Integer> t = new ArrayList<Integer>();
                t.add(test[0]);
                t.add(test[1]);
                lst.add(t);
            }
            else
            {
                int j = lst.size()-1;
                if (test[0] > lst.get(j).get(1))
                {
                    List<Integer> t = new ArrayList<Integer>();
                    t.add(test[0]);
                    t.add(test[1]);
                    lst.add(t);
                    continue;
                }
                else
                {
                    /*while(j>=0&&lst.get(j).get(0) > test[1])
                    {
                        j--;
                    }
                    if (j == -1)
                    {
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(test[0]);
                        t.add(test[1]);
                        lst.add(0,t);
                        continue;
                    }*/
                    if (test[0]<lst.get(j).get(0))
                    {
                        lst.get(j).set(0,test[0]);
                        
                    }
                    if (test[1]>lst.get(j).get(1))
                    {
                        lst.get(j).set(1,test[1]);
                    }
                }
            }
        }
        
        int[][] ans = new int[lst.size()][2];
        for (int i = 0; i<lst.size();i++)
        {
            ans[i][0] = lst.get(i).get(0);
            ans[i][1] = lst.get(i).get(1);
        }
        return ans;
    }
}

/*
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
*/