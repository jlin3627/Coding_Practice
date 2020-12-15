
/*
class Solution {
    public String longestPalindrome(String s) 
    {
        if (s.length() == 0 || s.length() == 1) return s;
        int ans = 1;
        int start = 0;
        String fin = s.substring(0,1);
        String test;
        
        for (int i = 0; i<s.length(); i++)
        {
            for (int j = i; j<s.length();j++)
            {
                int flag = 1;
                for (int k =0; k< (j-i+1) / 2; k++)
                {
                    if (s.charAt(i+k) != s.charAt(j-k))
                    {
                        flag = 0;
                    }
                }
                if (flag!=0 && (j-i+1) > ans )
                {
                    start = i;
                    ans = j -i + 1;
                }
            }
        }
        fin = s.substring(start, start+ans);
        return fin;
    }
    
    public String longestPalindrome(String s)
    {
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        int max = 1;
        for (int i = 0; i<s.length(); i++)
        {
            dp[i][i] = true;
        }
        
        int start = 0;
        for (int i = 0; i<s.length()-1; ++i)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] = true;
                start = i;
                max = 2;
            }
        }
        
        for (int k = 3; k<=s.length(); ++k)
        {
            for (int i = 0; i<s.length()-k+1; ++i)
            {
                int j = i+k-1;
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j))
            {
                dp[i][j] = true;
                if (k>max)
                {
                    start = i;
                    max = k;
                }
            }
            }
            
            
        }
        String ans = s.substring(start,start+max);
        return ans;
        
    }
}*/


/*public class Solution 
{
    private int lo, maxLen;

    public String longestPalindrome(String s) 
    {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) 
        {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) 
    {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) 
        {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) 
        {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}*/


class Solution 
{
    public String longestPalindrome(String s) 
    {
        String ans = "";
        for (int i = 0; i< s.length(); i++)
        {
            String s1 = countP(s,i,i), s2 = countP(s,i,i+1);
            if(s1.length() > ans.length()) ans = s1;
            if (s2.length()> ans.length()) ans = s2; 
        }
        return ans;
    }
    private String countP(String s, int i, int j)
    {
        for(; i >= 0 && j < s.length(); i--, j++)
        {
            if(s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i+1,j);
    }
}



/*class Solution
{
    public String longestPalindrome(String s) 
    {
      int n = s.length();
      String res = null;

      boolean[][] dp = new boolean[n][n];

      for (int i = n - 1; i >= 0; i--) 
      {
        for (int j = i; j < n; j++) 
        {
          dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

          if (dp[i][j] && (res == null || j - i + 1 > res.length())) 
          {
            res = s.substring(i, j + 1);
          }
        }
      }

      return res;
    }
}
*/



/*

Non dp practice

class Solution
{
    public String longestPalindrome(String s)
    {
        String ans = "";
        for (int i = 0;i<s.length();i++)
        {
            String s1 = countP(S,i,i), s2 = countP(s,i, i+1);
            if (s1.length() > ans.length()) ans = s1;
            if (s2.length() > ans.length()) ans = s2;
        }
        return ans;
    }

    private String countP(String s, int i, int j)
    {
        for (; i>=0 && j<s.length(); i--, j++)
        {
            if(s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i+1, j);
    }
}

class Solution
{
    public String longestPalindrome(String s)
    {
        String ans = "";
        for(int i = 0; i<s.length();i++)
        {
            String s1 = countP(S,i,i), s2 = countP(s,i,i+1);
            if(s1.length() > ans.length()) ans = s1;
            if(s2.length()>ans.length()) ans = s2;
        }
        return ans;
    }

    private String countP(String s, int i, int j)
    {
        for (; i>=0 && j<s.length();i--,j++)
        {
            if(s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i+1, j);
    }
}

class Solution
{
    public String longestPalindrome(String s)
    {
        String ans = "";
        for (int i = 0; i<s.length();i++)
        {
            String s1 = countP(S,i,i), s2 = countP(s,i,i+1);
            if(s1.length() > ans.length()) ans = s1;
            if(s2.length()>ans.length()) ans = s2;
        }
        return ans;
    }

    private String countP(String s, int i, int j)
    {
        for (; i>=0 && j<s.length();i--,j++)
        {
            if(s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i+1, j);
    }
}

*/


/* solution dp practice

class Solution
{
    public String longestPalindrome(String s) 
    {
      int n = s.length();
      String res = null;

      boolean[][] dp = new boolean[n][n];

      for (int i = n - 1; i >= 0; i--) 
      {
        for (int j = i; j < n; j++) 
        {
          dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

          if (dp[i][j] && (res == null || j - i + 1 > res.length())) 
          {
            res = s.substring(i, j + 1);
          }
        }
      }

      return res;
    }
}

class Solution
{
    public String longestPalindrome(String s)
    {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n -1; i>=0; i--)
        {
            for (int j = i; j<n; j++)
            {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);

                if (dp[i][j] && (res==null || j-i +1 > res.length()))
                {
                    res = s.substring(i,j+1);
                }

            }
        }
        return res;
    }
}

class Solution
{
    public String longestPalindrome(String s)
    {
        int n = s.length();
        String res = null;
        
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i>=0; i--)
        {
            for (int j = i; j<n; j++)
            {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if (dp[i][j] && (res==null || j-i+1 > res.length()))
                {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}

class Solution
{
    public String longestPalindrome(String s)
    {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1; i>=0; i--)
        {
            for (int j = i; j<n; j++)
            {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <3 || dp[i+1][j-1]);
                if (dp[i][j] && (res == null || j-i+1 > res.length()))
                {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}

*/