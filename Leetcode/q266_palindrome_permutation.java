public class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        for (char i = 0; i < 128 && count <= 1; i++) {
            int ct = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i)
                    ct++;
            }
            count += ct % 2;
        }
        return count <= 1;
    }
}

/*class Solution {
    public boolean canPermutePalindrome(String s) 
    {
        Map<Character, Integer> mp = new HashMap<>();
        
        for (char c:s.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        boolean odd = false;
        for (int n:mp.values())
        {
            if (n%2==1)
            {
                if (!odd) odd = true;
                else
                    return false;
            }
        }
        return true;
    }
}*/

/*public class Solution 
{
    public boolean canPermutePalindrome(String s) 
    {
        Map<Character, Integer> mp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
             mp.put(c,mp.getOrDefault(c,0)+1);
            if (mp.get(c) % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}*/

/*

public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}