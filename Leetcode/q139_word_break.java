class Solution {
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        /*Set<String> st = new HashSet<String>();
        for (String w:wordDict)
        {
            st.add(w);
        }*/
        
        /*for(int i = 1; i<=s.length(); i++)
        {
            for (int j =0; j<i ;j++)
            {
                if(dp[j] && st.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }*/
        for (int i = 1; i<=s.length();i++)
        {
            for (String str:wordDict)
            {
                if(str.length()<=i && dp[i-str.length()])
                {
                    if(s.substring(i-str.length(),i).equals(str))
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        
        return dp[s.length()];
    }
}

public class Solution
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i<=s.length();i++)
        {
            for (int j = 0; j<i;j++)
            {
                if (dp[j] && wordDictSet.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
            /*for (int k = 0; k<dp.length;k++)
            {
                System.out.print(dp[k]);
                System.out.print('-');
            }
            System.out.println();*/
        }
        return dp[s.length()];
    }
    
}