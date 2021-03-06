class Solution 
{
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first)
    {
        if (first == n) output.add(new ArrayList<Integer>(nums));
        for (int i = first; i<n;i++)
        {
            Collections.swap(nums,first,i);
            backtrack(n,nums,output,first+1);
            Collections.swap(nums,first,i);
        }
    }

    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> num_lst = new ArrayList<Integer>();
        for (int num:nums)
        {
            num_lst.add(num);
        }

        int n = nums.length;
        backtrack(n,num_lst,output,0);
        return output;
    }
}

/*

public List<List<Integer>> permute(int[] nums)
{
    List<List<Integer>> output = new LinkedList<>();
    ArrayList<Integer> num_lst = new ArrayList<Itneger>();
    for (int num:nums)
    {
        num_lst.add(num);
    }

    int n = nums.length;
    backtrack(n,num_lst,output,0);
    return output;
}

public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>>output, int first)
{
    if (first == n) output.add(new ArrayList<Integer>(nums));
    for (int i = first; i<n;i++)
    {
        Collections.swap(nums,first,i);
        backtrack(n,nums,output,first+1);
        Collections.swap(nums,first,i);
    }

}



public List<List<Integer>> permute(int[] nums)
{
    List<List<Integer>> output == new LinkedList<>();
    ArrayList<Integer> num_lst = new ArrayList<Integer>();
    for (int num:nums)
    {
        num_lst.add(num);
    }

    int n = nums.length;
    backtrack(n,num_lst,output,0);
    return output
}

public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>>output, int first)
{
    if (first == n) output.add(new ArrayList<Integer>(nums));
    for (int i = first; i<n;i++)
    {
        Collections.swap(nums,first,i);
        backtrack(n,nums,output,first+1);
        Collections.swap(nums,first,i);
    }
}

*/

class Solution
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
        } else{
        for(int i = 0; i < nums.length; i++){ 
            if(tempList.contains(nums[i])) continue; // element already exists, skip
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
        }
    } 
}


class Solution
{
    public List<List<Integer>> permute(int[] num) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
            for (int j = 0; j<=i; ++j){            
               for (List<Integer> l : ans){
                   List<Integer> new_l = new ArrayList<Integer>(l);
                   new_l.add(j,num[i]);
                   new_ans.add(new_l);
               }
            }
            ans = new_ans;
        }
        return ans;
    }
}
 