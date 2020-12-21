class Solution {
    public int maxArea(int[] height) 
    {
        int max = 0;
        
        for (int i = 0; i<height.length; i++)
        {
            for (int j = height.length - 1; j>i; j--)
            {
                int tmpArea = Math.min(height[i],height[j]) * (j-i);
                if (tmpArea > max) max = tmpArea;
            }
        }
        return max;
    }
}


class Solution {
    public int maxArea(int[] height) 
    {
        int max = 0, l = 0, r = height.length-1;
        while (l<=r)
        {
            int tmp = (r - l )*Math.min(height[l],height[r]);
            if (tmp>max) max = tmp;
            if (height[l]<height[r]) l++;
            else r--;
        }
        return max;
    }
    
}
