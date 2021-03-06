/*
0
01
0110
01101001
0110100110010110
01101001100101101001011001101001

*/
/*class Solution 
{
    private double fastPow(double x, long n)
    {
        if (n == 0)
        {
            return 1.0;
        }
        double half = fastPow(x, n/2);
        if (n%2 == 0)
        {
            return half * half;
        }
        else
        {
            return half*half*x;
        }
    }
    
    public double myPow(double x, int n) 
    {
        long N = n;
        if (N<0)
        {
            x = 1/x;
            N = -N;
        }
        return fastPow(x,N);
    }
}*/


class Solution
{
    public double myPow(double x, int n)
    {
        long N = n;
        if (N<0)
        {
            x = 1/x;
            N = -N;
        }
        
        double ans = 1;
        double cur = x;
        for (long i = N; i>0; i /= 2)
        {
            if ((i%2) == 1)
            {
                ans = ans * cur;
            }
            cur = cur * cur;
        }
        return ans;
    }
    
}




/* class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }
};*/