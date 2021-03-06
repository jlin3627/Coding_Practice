/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*public class Solution extends VersionControl {
    public int firstBadVersion(int n) 
    {
        boolean bFind = false;
        int start=1;
        int end=n;
        int mid= start + (end - start) / 2;
        while(start<end)
        {
            boolean fNow =  isBadVersion(mid);
            boolean fPrev = isBadVersion(mid-1);
            if (fNow && !fPrev) return mid;
            else if (!fNow && !fPrev)
            {
                start = mid+1;
            }
            else 
            {
                end = mid-1;
            }
            mid= start + (end - start) / 2;
        }
        return mid;
    }
}*/

/*class Solution extends VersionControl
{
    public int firstBadVersion(int n) 
    {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}*/

class Solution extends VersionControl
{
public int firstBadVersion(int n) {
        
        int l = 0;
        while(l<n){
            int mid = l + (n-l)/2;
            if(!isBadVersion(mid))
                l = mid + 1;
            else
                n = mid;
        }
        
        return l;
    }
}