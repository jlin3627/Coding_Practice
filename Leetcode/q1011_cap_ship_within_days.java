/*class Solution {
    public int shipWithinDays(int[] weights, int D) 
    {
        int start = 0, end = weights.length - 1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i<D;i++)
        {
            int mid = start + (end - start) / 2;
            int tmpSum = 0;
            for (int j = 0; j<=mid; j++)
            {
                if (j < weights.length-1)
                tmpSum+=weights[j];
            }
            if (tmpSum<min) min = tmpSum;
            start = mid + 1;
        }
        return min;
    }
}*/

class Solution
{
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

Explanation of this solution:

The key is left = max(weights), right = sum(weights),
which are the minimum and maximum possible weight capacity of the ship.

Therefore the question becomes Binary Search to find the minimum weight capacity of the ship between left and right.
We start from
mid = (left + right) / 2 as our current weight capacity of the ship.
need = days needed == 1
cur = current cargo in the ship == 0

Start put cargo into ship in order.
when need > D, it means the current ship is too small, we modify left = mid + 1 and continue
If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
Finally, when our left == right, we reach our answer


*/


/*class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // use binary search to find the optimal weight
        int low = 1, high = 25000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean can = canShip(weights, D, mid);
            if (can) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
	// check whether can ship under the given D and capacity
    private boolean canShip(int[] weights, int D, int capacity) {
        int day = 1, w = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity || day > D) return false;
            if (w + weights[i] > capacity) {
                w = weights[i];
                day++;
            } else {
                w += weights[i];
            }
        }
        return day <= D;
    }
}*/

/*class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int high = computeMaxWeight(weights, D);
        int low = maxWeight(weights);
        while (low + 1 < high) {
            int mid = (low + high)/2;
            if (validCapacity(weights, D, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return validCapacity(weights, D, low)? low : high;

    }

    private int maxWeight(int[] weights) {
        int res = weights[0];
        for (int w : weights) {
            res = Math.max(res, w);
        }
        return res;
    }

    private boolean validCapacity(int[] weights, int D, int cap) {
        int days = 0;
        int shipCap = 0;
        for (int weight : weights) {
            if (shipCap < weight) {
                days++;
                shipCap = cap;
            }
            shipCap -= weight;
        }
        return days <= D;
    }

    private int computeMaxWeight(int[] weights, int D) {
        int windowSize = weights.length/D + (weights.length%D == 0? 0 : 1);
        int[] sums = new int[weights.length];
        sums[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            sums[i] = sums[i-1] + weights[i];
        }
        int res = sums[windowSize-1];
        for (int i = weights.length-1; i>= windowSize; i--) {
            res = Math.max(sums[i] - sums[i-windowSize], res);
        }

        return res;
    }
}*/


/*class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l=1;
        int x = weights.length / D + 1;
        int mx = 0;
        for (int i : weights) {
            if (i > mx) {
                mx = i;
            }
        }
        int r = mx * x;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (possible(mid, weights, D)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private boolean possible(int cap,int[] weights, int D) {
        int s=0;
        int res = 0;
        for (int i=0;i<weights.length;i++) {
            if (s+weights[i]<=cap) {
                s+=weights[i];
            } else if (weights[i]<=cap){
                s=weights[i];
                res++;
                if (res > D) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (s > 0) {
            res++;
        }
        return res<=D;
    }
}*/

/*class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l=weights.length;
        int start=1;
        int end=(l/D+1)*500;
        int mid;
        
     
        while(start<end) {
            mid=start+(end-start)/2;
            if(checkIfPossibleInAtLeastDdays(weights,D,mid)) {
                
                end=mid;
            }else {
                start=mid+1;
            }
        }
        
        return start;
    }
    
    boolean checkIfPossibleInAtLeastDdays(int[] weights, int D, int shipCapacity) {
        int numOfDays=0;
        int remaining=shipCapacity;
        for(int i=0;i<weights.length;i++) {
            if(weights[i]>shipCapacity){
                return false;
            }
            remaining-=weights[i];
            if(remaining<0) {
                numOfDays++;
                remaining=shipCapacity-weights[i];
            }
        }
            numOfDays++;
        
        return numOfDays<=D;
        
        
    }
}*/

