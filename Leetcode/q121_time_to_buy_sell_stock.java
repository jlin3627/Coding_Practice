/*class Solution {
    public int maxProfit(int[] prices) 
    {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i<prices.length;i++)
        {
            if (prices[i]<min)
            {
                min = prices[i];
                for (int j = i; j<prices.length;j++)
                {
                    if (prices[j] > min && (prices[j] - min > ans) )
                    {
                        ans = prices[j] - min;
                    }
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    public int maxProfit(int[] prices) 
    {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i<prices.length;i++)
        {
            if (prices[i]<min)
            {
                min = prices[i];
            }
            else if (prices[i] - min>ans)
            {
                ans = prices[i] - min;
            }
        }
        return ans;
    }
}


