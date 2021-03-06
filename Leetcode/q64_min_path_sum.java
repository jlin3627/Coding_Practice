class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[m-1].length;
        for (int i = 0; i<grid.length; i++)
        {
            for (int j = 0; j<grid[i].length; j++)
            {
                if (i >= 1 && j>=1)
                {
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
                else if (i>=1 && j == 0)
                {
                    grid[i][j] += grid[i-1][j];
                }
                else if (i==0 && j >= 1)
                {
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}