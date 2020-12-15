class Solution {
    public String[] getFolderNames(String[] names) 
    {
        Map<String, Integer> mp = new HashMap<String,Integer>();
        String[] ans = new String[names.length];
        for (int i = 0; i<names.length; i++)
        {
            String name = names[i];
            if (!mp.containsKey(name))
            {
                mp.put(name,1);
                ans[i] = name;
            }
            else
            {
                String newName = name;
                int k = mp.get(newName);    
                while (mp.containsKey(newName))
                {
                    newName = name + '(' + k + ')';
                    k++;
                }
                mp.put(name, k);
                mp.put(newName, 1);
                ans[i] = newName;
            }
        }
        return ans;
    }
}

// class Solution
/*
class Solution
{
    public String[] getFolderNames(String[] names)
    {
        Map<String, Intger> mp = new HashMap<String, Integer>();
        String[] ans = new String[names.length];
        for (int i = 0; i<names.length; i++)
        {
            String name = names[i];
            if (!mp.containsKey(name))
            {
                mp.put(name,1);
                ans[i] = name;
            }
            else
            {
                String newName = name;
                int k = mp.get(newName);
                while(mp.containsKey(newName))
                {
                    newName = name + '(' + k + ')';
                    k++;
                }
                mp.put(name,k);
                mp.put(newName, 1);
                ans[i] = newName;
            }
        }
        return ans;
    }
}

class Solution
{
    public String[] getFolderNames(String[] names)
    {
        Map<String, Integer> mp = new HashMap<String Integer>();
        String[] ans = new String[names.length];
        for (int i = 0; i<names.length; i++)
        {
            String name = names[i];
            if (!mp.containsKey(name))
            {
                mp.put(name,1);
                ans[i] = name;
            }
            else
            {
                
                String newName = name + '(' + k + ')';
                k++;
                while (mp.containsKey(newName))
                {
                    newName = name + '(' + k + ')';
                    k++;
                }
                mp.put(name,k);
                mp.put(newName, 1);
                ans[i] = newName;
            }
        }
        return ans;
    }
}

class Solution
{
    public String[] getFolderNames(String[] names)
    {
        Map<String, Integer> mp = new HashMap<String, Integer>();
        String[] ans = new String[names.length];
        for (int i = 0; i<names.length; i++)
        {
            String name = names[i];
            if (!mp.containsKey(name))
            {
                mp.put(name,1);
                ans[i] = name;
            }
            else
            {
                String newName = name +'(' + k + ')';
                k++;
                while (mp.containsKey(newName))
                {
                    newName = name + '(' + k + ')';
                    k++;
                }
                mp.put(name,k);
                mp.put(newName, 1);
                ans[1] = newName;
            }
        }
        return ans;
    }
}
*/