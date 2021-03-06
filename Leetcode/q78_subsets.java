class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        dfs(ans,new ArrayList<>(),nums,0,0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans,List<Integer> tmpList ,int[] nums, int start, int length)
    {
        if (tmpList.size()==length)
        {
            //System.out.println(tmpList);
            ans.add(new ArrayList(tmpList));
        }
        
        for (int i = start; i<nums.length; i++)
        {
            if (tmpList.contains(nums[i])) continue;
            if (tmpList.size()>0 && nums[i] < tmpList.get(tmpList.size()-1)) continue;
            tmpList.add(nums[i]);
            dfs(ans,tmpList,nums,start+1,length+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}

public List<List<Integer>> subsets(int[] nums)
{
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(),nums,0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start)
{
    list.add(new ArrayList<>(tempList));
    for (int i = start; i<nums.length; i++)
    {
        tempList.add(nums[i]);
        backtrack(list,tempList, nums, i+1);
        tempList.remove(tempList.size()-1);
    }
}

/*class Solution {
    
    // https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     public List<List<Integer>> subsets(int[] nums) 
     {
          List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(nums);
         backtrack(ans, new ArrayList<>(), nums, 0);
         return ans;
     }
     
     private void backtrack(List<List<Integer>> lst, List<Integer> tempList, int []nums, int start)
     {
         lst.add(new ArrayList<>(tempList));
         for(int i = start; i < nums.length; i++)
         {
              if(i > start && nums[i] == nums[i-1]) continue;
             tempList.add(nums[i]);
             backtrack(lst, tempList, nums, i+1);
             tempList.remove(tempList.size()-1);
         }
     }
 }*/