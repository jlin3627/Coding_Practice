/*class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
    
    public void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results)
    {
        if(remain == 0)
        {
            results.add(new ArrayList<Integer>(comb));
        }
        else if (remain < 0)
        {
            return;
        }
        
        for (int i = start; i<candidates.length; i++)
        {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            comb.removeLast();
        }
        
    }
}*/

/*public class Solution 
{
    public List<List<Integer>> combinationSum(int[] cands, int t) 
    {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) 
                    {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++)
            dp[i] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int candidate: candidates) {
            for (int j = candidate; j <= target; j++) {                
                for (List<Integer> comb: dp[j - candidate]) {
                    List<Integer> newComb = new ArrayList(comb);
                    newComb.add(candidate);
                    dp[j].add(newComb);
                }                    
            }
        }
        return dp[target];
    }
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) 
        {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(ans, new ArrayList<>(),candidates,target, 0);
            return ans;
        }
        
        private void backtrack(List<List<Integer>> lst, List<Integer> tmpList, int[] nums, int target, int start)
        {
            if (target == 0)
            {
                lst.add(new ArrayList<>(tmpList));
            }
            for (int i = start; i<nums.length;i++)
            {
                if ( target - nums[i] <0) break;
                tmpList.add(nums[i]);
                backtrack(lst,tmpList,nums,target - nums[i], i);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }