public class binarySearch 
{
    public boolean binarySearch(int[] nums, int target) 
    {
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


/*
practice below

public boolean binarySearch(int[] nums, int target)
{
    int low = 0;
    int high = nums.length -1;
    while (low<=high)
    {
        int mid = low +(high - low)/2;
        if (nums[mid] == target)
        {
            return true;
        }
        if (nums[mid] > target)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return false;
}

public boolean binarySearch(int[] nums, int target)
{
    int low = 0;
    int high = nums.length -1;
    while(low <= high)
    {
        int mid = low + (high - low)/2;
        if (nums[mid] == target)
        {
            return true;
        }
        else if (nums[mid] > target)
        {
            high = mid -1;
        }
        else //if (nums[mid] < target)
        {
            low = mid+1;
        }
    }
}

public boolean binarySearch(int[] nums, int target)
{
    int low = 0;
    int high = nums.length -1;
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target)
        {
            return true;
        }
        else if (nums[mid] > target)
        {
            high  = mid -1;
        }
        else // if (nums[mid] < target)
        {
            low = mid +1;
        }
    }
}
*/ 