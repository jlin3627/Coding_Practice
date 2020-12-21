/*class Solution {
    public int orangesRotting(int[][] grid) 
    {
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        int fresh = 0;
        for (int i = 0; i<grid.length; i++)
        {
            for (int j = 0; j<grid[i].length; j++)
            {
                if (grid[i][j] == 2)
                {
                    queue.add(new Pair(i,j));
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        
        int ans = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue.add(new Pair(-1,-1));
        while (!queue.isEmpty())
        {
            Pair<Integer, Integer> tp = queue.poll();
            if (tp.getKey() == -1)
            {
                ans++;
                if (!queue.isEmpty())
                {
                    queue.offer(new Pair(-1,-1));
                }
            }
            else
            {
                for (int[] d: directions)
                {
                    int nRow = tp.getKey() + d[0];
                    int nCol = tp.getValue() + d[1];
                    if (nRow >=0 && nRow<grid.length && nCol>=0 && nCol<grid[nRow].length )
                    {
                        if (grid[nRow][nCol] == 1)
                        {
                            grid[nRow][nCol] = 2;
                            fresh--;
                            queue.add(new Pair(nRow, nCol));
                        }
                    }
                    
                }
            }
        }
        
        return fresh>0? -1:ans;
    }
}*/

/*class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS && 
                        neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}*/

/*class Solution {
    public int orangesRotting(int[][] grid) { 
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<Position> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Position(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[] dirX = new int[]{1, -1, 0, 0};
        int[] dirY = new int[]{0, 0, 1, -1};
        int minutes = 0;
        while (!queue.isEmpty()) {
            minutes++; 
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur.x + dirX[j];
                    int nextY = cur.y + dirY[j];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                        fresh--;
                        queue.offer(new Position(nextX, nextY));
                        grid[nextX][nextY] = 2;
                    }
                }  
            }  
        }
        return fresh == 0 ? minutes - 1 : -1;
    }
    
    class Position{
        int x; 
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}*/
class Solution {
    int max = 0;
    public int orangesRotting(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    helper(grid,i,j,2);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1) return -1;
                else{
                    max = Math.max(max,grid[i][j]-2);
                }
            }
        }    
                
        return max;
    }
    private void helper(int[][] grid, int i,int j,int val){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0||grid[i][j]>1&&grid[i][j]<val) return;
        grid[i][j] = val;
        helper(grid,i+1,j,val+1);
        helper(grid,i-1,j,val+1);
        helper(grid,i,j+1,val+1);
        helper(grid,i,j-1,val+1);
    }
}