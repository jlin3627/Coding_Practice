/*class Solution {
    public String gcdOfStrings(String str1, String str2) 
    {
        String test = str1.length()<str2.length()? str1:str2;
        String test2 = str1.length()<str2.length()? str2:str1;
        for(int i = test.length(); i>0; i--)
        {
            if (test2.length() % i == 0 && test.length() % i == 0)
            {
                for ( int j = 0; j+i<=test.length(); j++)
                {
                    String tSub = test.substring(j,j+i);
                    int count = 0;
                    boolean find = true;
                    for (int k = 0; k<test2.length();k++)
                    {
                        if(tSub.charAt(count)!=test2.charAt(k))
                        {
                            find = false;
                            break;
                        }
                        count++;
                        if (count>=tSub.length()) count = 0;
                    }
                    count = 0;
                    if (tSub.length()!=test.length())
                    {
                        for (int k = 0; k<test.length();k++)
                        {
                            if(tSub.charAt(count)!=test.charAt(k))
                            {
                                find = false;
                                break;
                            }
                            count++;
                            if (count>=tSub.length()) count = 0;
                        }
                    }
                    
                    if (find) return tSub;
                }
            }
            
        }
    
        String ans = "";        
        return ans;
    }
}*/
class Solution
{
    public String gcdOfStrings(String str1, String str2) 
    {
        if (str1.length() < str2.length()) { // make sure str1 is not shorter than str2.
            return gcdOfStrings(str2, str1); 
        }else if (!str1.startsWith(str2)) { // shorter string is not common prefix.
            return ""; 
        }else if (str2.isEmpty()) { // gcd string found.
            return str1;
        }else { // cut off the common prefix part of str1.
            return gcdOfStrings(str1.substring(str2.length()), str2); 
        }
    }
}

/*
practice below

class Solution
{
    public String gcdOfStrings(String str1, String str2)
    {
        if (str1.length() < str2.length())
        {
            return gcdOfStrings(str2, str1);
        }
        else if (!str1.startsWith(str2))
        {
            return "";
        }
        else if (str2.isEmpty())
        {
            return str1;
        }
        else
        {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}

class Solution
{
    public String gcdOfStrings(String str1, String str2)
    {
        if (str1.length() < str2.length())
        {
            return gcdOfStrins(str2, str1);
        }
        else if (!str1.startsWith(str2))
        {
            return "";
        }
        else if (str2.isEmpty())
        {
            return str1;
        }
        else
        {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}

class Solution
{
    public String gcdOfStrings(String str1, String str2)
    {
        if (str1.length() < str2.length())
        {
            return gcdOfStrings(str2, str1);
        }
        else if (!str1.startsWith(str2))
        {
            return "";
        }
        else if (str2.isEmpty())
        {
            return str1;
        }
        else
        {
            return gcdOfStrins(str1.substring(str2.length()),str2);
        }
    }
}
*/ 