/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

/*class Solution 
{
    int max = 101;

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int m = dimension.get(0);
        int n = dimension.get(1);
        int min = max;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, binarySearch(binaryMatrix, i, n));
        }
        return min == max ? -1 : min;
    }
    private int binarySearch(BinaryMatrix bm, int row, int n) {
        if (bm.get(row, n - 1) == 0) return max;
        if (bm.get(row, 0) == 1) return 0;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (bm.get(row, mid) == 1) {
              hi = mid - 1;
            } else {
              lo = mid + 1;
            }
        }
        return lo;
    }
}*/


class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) 
    {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0);
        int n = dim.get(1);
        int res = -1;
        int row = 0; int col = n - 1;
        while (row < m && col >=0)
        {
            if (binaryMatrix.get(row,col) == 1)
            {
                res = col;
                col--;
            }
            else
            {
                row++;
            }
        }
        return res;
    }
}

