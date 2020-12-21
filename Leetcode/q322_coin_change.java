/*class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if (amount == 0)
        {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int tmpAns = Integer.MAX_VALUE;
        for (int i = coins.length-1; i>=0; i--)
        {
            int tmp = amount - coins[i];
            if (tmp > 0)
            {
                int rem = coinChange(coins, tmp);
                if (rem!=-1)
                {
                    tmpAns = 1 + rem;
                }
                else
                {
                    tmpAns = Integer.MAX_VALUE;
                }
            }
            else if (tmp == 0)
            {
                return 1;
            }
            if (tmpAns<ans) ans = tmpAns;
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}*/

//top down
class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int rem, int[] count)
    {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem -1] !=0) return count[rem -1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins)
        {
            int res = coinChange(coins, rem - coin, count);
            if (res >=0 && res< min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1: min;
        return count[rem-1];
        
    }
}

// bottom up
public class Solution
{
    public int coinChange(int[] coins, int amount)
    {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i<= amount; i++)
        {
            for (int j = 0; j<coins.length; j++)
            {
                if (coins[j]<=i)
                {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
}


// dfs 100% solution
class Solution {
    
    private int result = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
		dfs(coins, coins.length-1, amount, 0);
		return (result == Integer.MAX_VALUE) ? -1 : result;
    }
    
    private void dfs(int[] coins, int index, int amount, int count) {
		if(index < 0) return;
		
		int times = amount/coins[index];
		while(times >= 0) {
			int remainingAmount = amount - (times*coins[index]);
			int newCount = count+times;
			if(remainingAmount == 0) {
				result = Math.min(result, newCount);
				return;
			}
			
			if(newCount+1 >= result) break;
			
			dfs(coins, index-1, remainingAmount, newCount);
			times--;
		}
	}
}
 
/*
public class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;
        
        while(++sum<=amount) 
        {
            int min = -1;
            for(int coin : coins) 
            {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
    }*/
