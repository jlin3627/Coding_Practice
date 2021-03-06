class Solution {
    int mod = 1000000007;
    public int countPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        long res = 0;
        for (int num : arr) {
            int power = 1;
            for (int i = 0; i < 32; i++) {
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}


class Solution {
    static int MOD = 1_000_000_007;
    public int countPairs(int[] deliciousness) {
        long ans = 0;
        Arrays.sort(deliciousness);
        Map<Integer, Integer> seen = new HashMap<>();
        for (int d : deliciousness) {
            long prev = ans;
            if (d == 0) {}
            else if ((d & (d-1)) == 0) ans = (ans + seen.getOrDefault(0, 0) + seen.getOrDefault(d, 0)) % MOD;
            else {
                int h = Integer.highestOneBit(d) << 1;
                ans = (ans + seen.getOrDefault(h - d, 0)) % MOD;
            }
            seen.put(d, seen.getOrDefault(d, 0) + 1);
        }
        return (int) ans;
    }
}



class Solution {
    public int countPairs(int[] deliciousness) 
    {
        Map<Integer,Integer> mp = new HashMap<>();
        long count = 0;
        for (int t:deliciousness)
        {
            mp.put(t,mp.getOrDefault(t,0)+1);
        }
        
        List<Integer> lst = new ArrayList<>(mp.keySet());
        for (int i = 0; i<lst.size();i++)
        {
            if (mp.get(lst.get(i))>1)
            {
                int test = lst.get(i)+lst.get(i);
                if(test!=0 && ((test&(test-1)) == 0))
                {
                    int nums = mp.get(lst.get(i));
                    nums = (nums)*(nums-1) / 2;
                    count+=nums;
                }
            }
            for (int j=i+1;j<lst.size();j++)
            {
                int ans = lst.get(i)+lst.get(j);
                if (lst.get(i)!=lst.get(j))
                {
                    if ( ans!=0 && ((ans&(ans-1)) == 0))
                    count+=mp.get(lst.get(i))*mp.get(lst.get(j));
                }
                else
                {
                    if ( ans!=0 && ((ans&(ans-1)) == 0))
                    count+=mp.get(lst.get(j));
                }
            }
        }
        
        /*long count = 0;
        for (int i = 0; i<deliciousness.length;i++)
        {
            for(int j = i+1; j<deliciousness.length;j++)
            {
                int ans = deliciousness[i] + deliciousness[j];
                if ( ans!=0 && ((ans&(ans-1)) == 0))
                    count++;
            }
        }*/
        return (int)(count%1000000007);
    }
}