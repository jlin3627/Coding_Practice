class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end - start) / 2;
        boolean fFind = false;
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        while (start<=end)
        {
            if(nums[mid]<target)
            {
                start = mid+1;
            }
            else if (nums[mid]>target)
            {
                end = mid-1;
            }
            else
            {
                fFind = true;
                break;
            }
            mid = start + (end - start) / 2;
        }
        
        if (fFind)
        {
            start = mid;
            end = mid;
            while(start>=0 && nums[start] == target)
            {
                start--;
            }
            while(end<=nums.length-1 && nums[end] == target)
            {
                end++;
            }
            ans[0] = ++start;
            ans[1] = --end;
        }
        
        return ans;
    }
}

class Solution {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ans = {-1,-1};
        int left = binSearch(nums, target, true);
        if (left == nums.length || nums[left]!=target)
        {
            return ans;
        }
        
        ans[0] = left;
        ans[1] = binSearch(nums, target, false)-1;
        return ans;
    }
    
    private int binSearch(int[] nums, int target, boolean left)
    {
        int start = 0;
        int end = nums.length;
        while (start<end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target || (left && target == nums[mid]))
            {
                end = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return end;
    }
}

public class Solution 
{
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}