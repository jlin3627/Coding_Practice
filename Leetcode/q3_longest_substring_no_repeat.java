/*
class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Map<Character, Integer> check = new HashMap<Character, Integer>();
        int count = 0;
        char word;
        for (int j = 0, i = 0; j<s.length();j++)
        {
            word = s.charAt(j);
            if( check.containsKey(word) )
            {
                i = Math.max(check.get(word), i);
            }
            count = Math.max(count, j-i+1);
            check.put(word, j+1);
            
        }
        return count;
    }
}

*/

/*class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if (s.length()==0) return 0;
        int i = 0, j =0;
        int ans = 0;
        
        Set<Character> st = new HashSet<Character>();
        for (int k = 0; k<s.length();k++)
        {
            char c = s.charAt(k);
            if (!st.contains(c))
            {
                st.add(c);
            }
            else
            {
                int tmp = k-j;
                if (tmp>ans) ans = tmp;
                while(s.charAt(j)!=c)
                {
                    st.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
        }
        int tmp = s.length()-j;
        if (tmp>ans)
        {
            ans = tmp;
        }
        return ans;
        
    }
}*/

public class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        Set<Character> st = new HashSet<>();
        int ans = 0, i =0,j=0;
        while (i<n && j<n)
        {
            if (!st.contains(s.charAt(j)))
            {
                st.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }
            else
            {
                st.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
    
}

public class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j<n;j++)
        {
            if (map.containsKey(s.charAt(j)))
            {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
    
}