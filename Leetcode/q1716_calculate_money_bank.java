class Solution {
    public int totalMoney(int n) 
    {
        int[] ans = new int[n];
        ans[0] = 1;
        int week = 0;
        int add = 1;
        for (int i = 1; i<n;i++)
        {
            if (i%7 == 0) 
            {
               week++;
               add = week; 
            }
            add++;
            ans[i] = ans[i-1]+add;
        }
        return ans[n-1];
    }
}