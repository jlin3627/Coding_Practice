
//O(n^3)

public class Solution
{
    public int numTeams(int[] rating) 
    {
        int count = 0;
        for (int i = 0; i<rating.length; i++)
        {
            for (int j = i+1; j<rating.length; j++)
            {
                for (int k = j+1; k<rating.length; k++)
                {
                    if (rating[k] > rating[j] && rating[j] > rating[i])
                    {
                        count++;
                    }
                    else if (rating[k] < rating[j] && rating[j] < rating[i])
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

//O(n^2)
class Solution
{
    public int numTeams(int[] rating)
    {
        int count = 0;
        int len = rating.length;
        for (int j  =0 ;j <len; j++)
        {
            int leftSmaller = 0, rightLarger = 0;
            int leftLarger = 0, rightSmaller = 0;
    
            for (int i = 0; i<j;i++)
            {
                if (arr[i] < arr[j])
                {
                    leftSmaller++;
                }
                else if (arr[i] > arr[j])
                {
                    leftLarger++;
                }
            }
    
            for (int k= j+1; k<len; k++)
            {
                if (arr[j] < arr[k])
                {
                    rightLarger++;
                }
                else if (arr[j] > arr[k])
                {
                    rightSmaller++;
                }
            }
            count += leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return count;
    }
}

/*
class Solution
{
    public int numTeams(int[] rating)
    {
        int count = 0;
        int len = rating.length;
        for (int j = 0; j<len; j++)
        {
            int leftSmaller = 0, rightLarger = 0;
            int leftLarger = 0, rightSmaller = 0;

            for (int i = 0; i<j; i++)
            {
                if(arr[i] < arr[j])
                {
                    leftSmaller++;
                }
                else if (arr[i] > arr[j])
                {
                    leftLarger++;
                }
            }
            
            for (int k = j+1; k<len; k++)
            {
                if (arr[j] < arr[k])
                {
                    rightLarger++;
                }
                else if (arr[j] > arr[k])
                {
                    rightSmaller++;
                }
            }
            count+=leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return count;
    }
}
*/