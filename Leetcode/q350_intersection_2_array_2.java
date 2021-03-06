class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
         int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> lst = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) 
        {
 
            if (nums1[i] > nums2[j]) {
                j++;
            }
 
            else if (nums2[j] > nums1[i]) {
                i++;
            }
            else 
            {
                // when both are equal
                lst.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] ans = new int[lst.size()];
        for (int k = 0; k<lst.size();k++)
        {
            ans[k] = lst.get(k);
        }
        return ans;
    }
}

public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    HashMap<Integer, Integer> m = new HashMap<>();
    for (int n : nums1) {
        m.put(n, m.getOrDefault(n, 0) + 1);
    }
    int k = 0;
    for (int n : nums2) {
        int cnt = m.getOrDefault(n, 0);
        if (cnt > 0) {
            nums1[k++] = n;
            m.put(n, cnt - 1);
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}

public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}

vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    sort(begin(nums1), end(nums1));
    sort(begin(nums2), end(nums2));
    nums1.erase(set_intersection(begin(nums1), end(nums1),
        begin(nums2), end(nums2), begin(nums1)), end(nums1));
    return nums1;
}