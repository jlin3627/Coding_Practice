/*class Solution {
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        if (dominoes.length == 0) return 0;
        int count = 0;
       Map<String, Integer> mp = new HashMap<>();
        for (int[] dom: dominoes)
        {
            String key = Integer.toString(Math.min(dom[0], dom[1])) + '-' + Integer.toString(Math.max(dom[0], dom[1]));
            if (mp.containsKey(key))
            {
                count+=mp.get(key);
                mp.put(key,mp.get(key)+1);
            }
            else
            {
                mp.put(key,1);
            }
        }
        return count;
    }
}*/

public class Solution 
{
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            int iCount = count.getOrDefault(k, 0);
            res += iCount;
            count.put(k, iCount + 1);
        }
        return res;
    }    
}




/*class Solution
{
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        int[] count = new int[100];
        int ans = 0, index = 0;
        for (int[] dom : dominoes) {
            index = dom[0] < dom[1] ? dom[0] * 10 + dom[1] : dom[1] * 10 + dom[0];
            ans += count[index]++;
        }
        return ans;
    }
}*/