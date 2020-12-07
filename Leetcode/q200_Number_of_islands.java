/*class Solution 
{
    public boolean[][] checked;
    public int[][] mat;
    public int count;
    public int numIslands(char[][] grid) 
    {
        checked = new boolean[grid.length][grid[0].length];
        mat = new int[grid.length][grid[0].length];
        count = 0;
        for (int i = 0; i<grid.length; i++)
        {
            for (int j = 0; j<grid[i].length; j++)
            {
                boolean fTest = false;
                if (!checked[i][j])
                {
                    //System.out.print(i);
                    //System.out.print(",");
                    //System.out.println(j);
                    fTest = findIsland(grid, i,j,count);
                    if (fTest)
                    {
                        count++;
                    }
                        
                }
                
            }
        }
        return count;
    }
    
    public boolean findIsland(char[][] grid, int i,int j, int count)
    {
        boolean fTest = false;
        
        if ( checked[i][j] || grid[i][j] == '0')
        {
            checked[i][j] = true;
            return false;
        }
        else
        {
            checked[i][j] = true;
            if (grid[i][j] == '1') 
            {
                mat[i][j] = count;
                fTest = true;
            }
            if (i+1<grid.length) findIsland(grid,i+1,j,count);
            if (i-1>=0) findIsland(grid,i-1,j,count);
            if (j+1<grid[i].length) findIsland(grid,i,j+1,count);
            if (j-1>=0) findIsland(grid,i,j-1,count);
        }
        
        return fTest;
            
    }
}*/

class Solution {
    // TC O(M*N)
 public int numIslands(char[][] grid) {
    // handling the edge case
    if(grid == null || grid.length == 0) {
      return 0;
    }
    
    //defining the necessary varibles and DS
    int result = 0;
    for(int i = 0 ; i < grid.length ; i++){
      for(int j = 0 ; j < grid[0].length ; j++){
        // only for "1"
        if(grid[i][j] == '1'){
          // doing dfs
          result += dfs(i, j, grid); 
        }
      }
    }
    return result;
  }
  
  int dfs(int row, int col , char[][] grid){
    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
       grid[row][col] = '0';  // to make it visited
       dfs(row, col +1, grid);
       dfs(row +1, col, grid);
       dfs(row, col -1, grid);
       dfs(row -1, col, grid);
       return 1; 
    }
    return 0;
  } 
}