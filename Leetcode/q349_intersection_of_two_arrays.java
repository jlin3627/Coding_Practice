/*class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        int[] nums = nums1.length>nums2.length? nums1:nums2;
        int[] numChk = nums1.length>nums2.length? nums2:nums1;
        List<Integer> ans = new LinkedList<Integer>();
        Set<Integer> mp = new HashSet<Integer>();
        for (int i = 0; i<nums.length; i++)
        {
            mp.add(nums[i]);
        }
        for (int i = 0; i<numChk.length; i++)
        {
            if (mp.contains(numChk[i]))
            {
                ans.add(numChk[i]);
                mp.remove(numChk[i]);
            }
        }
        int[] finAns = new int[ans.size()];
        for (int i = 0; i<ans.size();i++)
        {
            finAns[i] = ans.get(i);
        }
        return finAns;
    }
}*/

/*public class Solution 
{
 
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i<nums1.length; i++)
        {
            set.add(nums1[i]);
        }
        for (int i = 0; i<nums2.length; i++)
        {
            if (set.contains(nums2[i]))
            {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect)
        {
            result[i++] = num;
        }
        return result;
    }
}*/

/*public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
