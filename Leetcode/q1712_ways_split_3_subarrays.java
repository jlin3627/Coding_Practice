class Solution {
    public int waysToSplit(int[] nums) {
      final int N = nums.length;
      int[] prefix = new int[N + 1];
      for (int i = 0; i < N; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
      }
      long res = 0;
      int i1 = N - 2;
      int i2 = N - 2;
      for (int j = N - 1; j >= 2; j--) {
        int right = prefix[N] - prefix[j];
        while (i1 > 0 && prefix[j] - prefix[i1] <= right) {
          i1--;
        }
        i2 = Math.min(i2, j - 1);
        while (i2 > 0 && prefix[i2] > prefix[j] - prefix[i2]) {
          i2--;
        }
        if (i2 > i1 && i1 >= 0) {
          res += (long) (i2 - i1);
        }      
      }    
      return (int) (res % 1_000_000_007);
    }
  }

  class Solution {
    static int MOD = 1000000007;
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        for (int i = 1; i < n; i++) p[i] = p[i-1] + nums[i];

        int i = 0;
        int j = 1;
        long ans = 0;

        while (i < n-2) {
            while (j < n-1 && p[j] - p[i] < p[i]) j++;
            if (j == n-1) break;
            if (p[j] - p[i] > p[n-1] - p[j]) {
                i++;
                j = Math.max(j, i+1);
                continue;
            }
            
            int l = j;
            int r = n-2;
            int best = l;
            while (l <= r) {
                int m = l + (r - l) / 2;
                int sumM = p[m] - p[i];
                int sumR = p[n-1] - p[m];
                if (sumM <= sumR) {
                    best = m;
                    l = m+1;
                } else r = m-1;
            }
            ans += best - j + 1;
            i++;
            j = Math.max(j, i+1);
        }
        return (int) (ans % MOD);
    }
}