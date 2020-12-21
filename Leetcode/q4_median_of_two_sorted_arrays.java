class Solution {
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n = nums1.length + nums2.length;
        if (n==0) return 0;
        int[] nums = new int[n];
        
        int i = 0, j = 0, k = 0;
        for (; i<nums1.length && j<nums2.length; )
        {
            if (nums1[i] < nums2[j])
            {
                nums[k] = nums1[i];
                i++;
                k++;
            }
            else
            {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        if (i<nums1.length)
        {
            for (;i<nums1.length;i++)
            {
                nums[k] = nums1[i];
                k++;
            }
        }
        
        if (j<nums2.length)
        {
            for (;j<nums2.length;j++)
            {
                nums[k] = nums2[j];
                k++;
            }
        }
        if (n == 1)
        {
            return nums[0];
        }
        
        if (n%2 == 0)
        {
            n = n/2;
            return (double)(nums[n-1] * 1.00000 +  ((nums[n] - nums[n-1])/ (2.00000) ) );
        }
        else
        {
            n= n/2;
            return (double)(nums[n]);
        }
    }*/
    
    
    /**
    public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Deal with invalid corner case. 
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0.0;
        
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median
        
        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that make up a median
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    
    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2
        
        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        
        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
        
        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
        
        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); //nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); //nums1 + nums2.right
        }
    }
}
    
    
    */
    // https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    
    public double findMedianSortedArrays(int[] A, int[] B)
    {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A,0,B,0,l) + getkth(A,0,B,0,r)) / 2.0;
    }
    
    public double getkth(int[] A, int aStart, int[] B, int bStart, int k)
    {
        if (aStart > A.length -1) return B[bStart + k - 1];
        if (bStart > B.length-1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);
        
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1<A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1<B.length) bMid = B[bStart + k/2 - 1];
        
        if (aMid < bMid)
            return getkth(A,aStart + k/2, B, bStart, k - k/2);
        else
            return getkth(A, aStart, B, bStart + k/2, k - k/2);
    }
}