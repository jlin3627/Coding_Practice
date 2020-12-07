/*class Solution {
    public int firstUniqChar(String s) 
    {
        Map<Character, Integer> st = new HashMap<>();
        int ans = -1;
        int n = s.length();
        for (int i =0 ; i<n ; i++)
        {
            char c = s.charAt(i);
            st.put(c, st.getOrDefault(c,0) + 1);
        }
        
        for (int i = 0; i<n; i++)
        {
            if(st.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }
        return -1;
    }
}*/
/*class Solution
{
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}
*/

class Solution
{
    public int firstUniqChar(String s)
    {
        int result = s.length();
        for(char c = 'a' ; c <= 'z'; c++)
        {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c))
                result = Math.min(result, index);
        }
        
        return result == s.length() ? -1 : result;
    }
}


/*
class Solution
{
    public int firstUniqChar(String s)
    {
        int result = s.length();
        for (char c= 'a'; c<= 'z'; c++)
        {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c))
            {
                result = Math.min(result,index);
            }
        }

        return result == s.length()? -1:result;
    }

}

class Solution
{
    public int firstUniqChar(String s)
    {
        int result = s.length();
        for(char c = 'a'; c<= 'z'; c++)
        {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c))
            {
                result = Math.min(result.index);
            }
        }
        return result == s.length()? -1:result;
    }
}
*/