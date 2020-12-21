class Solution {
    public boolean isPalindrome(int x) 
    {
        int neg = 1;
        if (x < 0) 
        {
            return false;
        }
        int oldx = x;
        int rev = 0;
        while (x/10 > 0 || x%10>0)
        {
            rev = rev*10 + x%10;
            x = x/10;
        }
        
        return  oldx == rev || oldx== rev/10;
    }
}