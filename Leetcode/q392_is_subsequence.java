class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        Map<Character,List<Integer>> mp = new HashMap<>();
        for (int i = 0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            if (!mp.containsKey(c))
            {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                mp.put(c,lst);
            }
            else
            {
                mp.get(c).add(i);
            }
        }
        
        int ind = -1;
        for (int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if (!mp.containsKey(c))
            {
                return false;
            }
            else
            {
                List<Integer> lst = mp.get(c);
                int pos = 0;
                boolean find = false;
                for (pos = 0; pos<lst.size();pos++)
                {
                    if (lst.get(pos)>ind)
                    {
                        ind = lst.get(pos);
                        mp.get(c).remove(pos);
                        find = true;
                        break;
                    }
                }
                if (!find) 
                {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        int ind = -1;
        for (int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            int test = -2;  
            
            while (test<ind)
            {
                test = t.indexOf(c);
                if (test == -1 ) 
                {
                    return false;
                }
                String nt = t.substring(0,test);
                if (test+1<t.length())
                {
                    nt+=t.substring(test+1);
                }
                t = nt;
            }
            
            ind = test;
        }
        return true;
    }
}

/*
class Solution {

    public boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}

*/