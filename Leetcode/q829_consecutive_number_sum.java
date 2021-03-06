class Solution {
    public int consecutiveNumbersSum(int N) {
         int res = 1, count;
         while (N % 2 == 0) N /= 2;
         for (int i = 3; i * i <= N; i += 2) {
             count = 0;
             while (N % i == 0) {
                 N /= i;
                 count++;
             }
             res *= count + 1;
         }
         return N == 1 ? res : res * 2;
     }
 }

 public int consecutiveNumbersSum(int N) {
    int sum = 0, ans = 0;
    for(int i = 1; sum < N; i++) {
        sum += i;
        if (((N-sum) % i) == 0)
            ans++;
    }
    return ans;
}