import java.util.*;

public class fib
{
    public int fib(int n)
    {
        if (n <=2) return 1;
        return fib(n-1) + fib(n-2);
    }
    
    public long fibM(int n, Map<Integer,Long> memo)
    {
        if(memo.containsKey(n)) return memo.get(n);
        if (n<=2) return 1;
        memo.put(n,fibM(n-1,memo) + fibM(n-2,memo));
        return memo.get(n);
    }

    public long fibA(int n, long[] memo)
    {
        if (n-1 <0) return 0;
        if(memo[n-1]!=0) return memo[n-1];
        if(n<=2) return 1; 
        memo[n-1] = fibA(n-1,memo) + fibA(n-2,memo);
        return memo[n-1];
    }
}
