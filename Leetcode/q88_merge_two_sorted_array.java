/*class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int[] nm1 = new int[m];
        for (int i = 0;i<m;i++)
        {
            nm1[i] = nums1[i];
        }
        
        int i = 0,j=0,ind=0;
        while(i<m&&j<n)
        {
            if (nm1[i]<nums2[j])
            {
                nums1[ind] = nm1[i];
                i++;
            }
            else
            {
                nums1[ind] = nums2[j];
                j++;
            }
            ind++;
        }
        
        if (i<m)
        {
            for (;i<m;i++)
            {
                nums1[ind] = nm1[i];
                ind++;
            }
        }
        if (j<n)
        {
            for (;j<n;j++)
            {
                nums1[ind] = nums2[j];
                ind++;
            }
        }
    }
}*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
      // two get pointers for nums1 and nums2
      int p1 = m - 1;
      int p2 = n - 1;
      // set pointer for nums1
      int p = m + n - 1;
  
      // while there are still elements to compare
      while ((p1 >= 0) && (p2 >= 0))
        // compare two elements from nums1 and nums2 
        // and add the largest one in nums1 
        nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
  
      // add missing elements from nums2
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
  }


  class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m-1, q = n-1, i = m+n-1;
        while ( q>=0 ) {
            if ( p<0 || B[q] >= A[p] )
                A[i--] = B[q--];
            else
                A[i--] = A[p--]; 
        }
    }
}