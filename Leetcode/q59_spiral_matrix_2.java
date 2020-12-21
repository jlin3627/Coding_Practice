class Solution {
    public int[][] generateMatrix(int n) 
    {
        int[][] ans = new int[n][n];
        
        int i = 0;
        int j = 0;
        int dirI = 0;
        int dirJ = 1;
        for (int v = 1; v<=n*n; v++)
        {
            ans[i][j] = v;
            if (i+dirI == n)
            {
                dirI = 0;
                dirJ = -1;
            }
            else if (j+dirJ == n)
            {
                dirI = 1;
                dirJ = 0;
            }
            else if (i+dirI < 0)
            {
                dirI = 0;
                dirJ = 1;
            }
            else if (j+dirJ < 0)
            {
                dirI = -1;
                dirJ = 0;
            }
            else if (ans[i+dirI][j+dirJ]!=0)
            {
                if (dirI == 0 && dirJ == 1)
                {
                    dirI = 1;
                    dirJ = 0;
                }
                else if (dirI == 1 && dirJ == 0)
                {
                    dirI = 0;
                    dirJ = -1;
                }
                else if (dirI == 0 && dirJ == -1)
                {
                    dirI = -1;
                    dirJ = 0;
                }
                else if (dirI == -1 && dirJ == 0)
                {
                    dirI = 0;
                    dirJ = 1;
                }              
            }
            i = i+dirI;
            j = j+dirJ;
        }
        return ans;
    }
}

/*
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }
        return result;
    }
}

*/

/*
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}

*/