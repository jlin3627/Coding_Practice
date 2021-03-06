class Solution
{
    public int findKthPositive(int[] arr, int k) 
    {
        int count = 0;
        int num = 1;
        int ind = 0;
        while ( count < k )
        {
            if (ind < arr.length)
            {
                if (num<arr[ind])
                {
                    count++;
                }
                else if (num>arr[ind])
                {
                    count++;
                }
                else if (num == arr[ind])
                {
                    ind++;
                }
            }
            else
            {
                count++;
            }
            
            if (count == k)
            {
                break;
            }
            num++;
        }
        return num;    
    }


    public int findKthPositive(int[] arr, int k) 
    {
        int count = 0;
        int num = 1;
        int ind = 0;
        while (count<k && ind < arr.length)
        {
            if (num == arr[ind])
            {
                ind++;
            }
            else
            {
                count++;
                if (count == k) return num;
            }
            num++;
        }
        return arr[arr.length-1] - count + k;
    }

    //https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC%2B%2BPython-O(logN)
    public int findKthPositive(int[] arr, int k)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int pivot = left + (right - left) / 2;
            if (arr[pivot] - pivot - 1<k)
            {
                left = pivot + 1;
            }
            else
            {
                right = pivot - 1;
            }
        }

        return left + k;
    }

}