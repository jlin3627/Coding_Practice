/*class Solution 
{
    public int countComponents(int n, int[][] edges) 
    {
        int[] test = new int[n];
        Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();
        int count = 0;
        for (int[] edge:edges)
        {
            if (test[edge[0]] != 0 && test[edge[1]] == 0)
            {
                test[edge[1]] = test[edge[0]];
                mp.get(test[edge[0]]).add(edge[1]);
            }
            else if (test[edge[0]] == 0 && test[edge[1]] != 0)
            {
                test[edge[0]] = test[edge[1]];
                mp.get(test[edge[1]]).add(edge[0]);
            }
            else if (test[edge[0]] != 0 && test[edge[1]] != 0)
            {
                if (test[edge[0]] != test[edge[1]])
                {
                    int nt = test[edge[0]] > test[edge[1]]? test[edge[1]] :test[edge[0]];
                    int oldn = test[edge[0]] > test[edge[1]]? test[edge[0]] :test[edge[1]];
                    List<Integer> lMove = mp.get(oldn);
                    for (int t:lMove)
                    {
                        test[t] = nt;
                        mp.get(nt).add(t);
                    }
                    mp.remove(oldn);
                }
                
            }
            else //if (test[edge[0]] == 0 && test[edge[1]] == 0)
            {
                count++;
                test[edge[0]] = count;
                test[edge[1]] = count;
                List<Integer> ltest = new LinkedList<Integer>();
                ltest.add(edge[0]);
                ltest.add(edge[1]);
                mp.put(count, ltest);
            }
        }
        for (int i = 0; i<n; i++)
        {
            if (test[i] == 0)
            {
                count++;
                List<Integer> ltest = new LinkedList<Integer>();
                ltest.add(i);
                mp.put(count,ltest);
            }
        }
        return mp.size();
    }
}*/


class Solution
{
    public int countComponents(int n, int[][] edges)
    {
        int[] test = new int[n];
        for (int i = 0; i<n; i++)
        {
            test[i] = i;
        }
        
        for (int[] edge : edges)
        {
            int root1 = findEdge(test,edge[0]);
            int root2 = findEdge(test, edge[1]);
            if (root1 != root2)
            {
                test[root1] = root2;
                n--;
            }
        }
        return n;
    }
    
    public int findEdge(int[] test, int id)
    {
        while(test[id]!=id)
        {
            test[id] = test[test[id]];
            id = test[id];
        }
        return id;
    }
    
}



