class Solution {
    public int countPrimes(int n) 
    {
        int count = 0;
        for (int i = 1; i<n;i++)
        {
            if(isPrime(i)) count++;
        }
        return count;
    }
    
    private boolean isPrime(int num)
    {
        if(num <= 1) return false;
        for (int i=2; i*i <=num;i++)
        {
            if(num % i == 0) return false;
        }
        return true;
    }
}

class Solution {
    public int countPrimes(int n) 
    {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i<n;i++)
        {
            isPrime[i] = true;
        }
        
        for (int i = 2; i*i<n;i++)
        {
            if(!isPrime[i]) continue;
            for(int j = i*i; j<n; j+= i)
            {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2;i<n;i++)
        {
            if(isPrime[i]) count++;
        }
        return count;
    }
    

}


public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}

