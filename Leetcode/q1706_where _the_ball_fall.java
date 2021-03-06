class Solution 
{
    public int[] findBall(int[][] grid) 
    {
        int[] answer = new int[grid[0].length];
        for (int i = 0; i < answer.length; i++) 
        {
            int x= i, y = 0;
            while (y < grid.length) 
            {
                if (grid[y][x] == 1){
                    if (x + 1 == answer.length || grid[y][x+1] ==-1) 
                    {
                        answer[i] = -1;
                        break;
                    }
                    else {
                        x+=1;
                        y+=1;
                    }
                }
                else {
                    if (x == 0 || grid[y][x-1] == 1) 
                    {
                        answer[i] = -1;
                        break;
                    }
                    else {
                        x-=1;
                        y+=1;
                    }
                }
            }
            if (answer[i]!= -1)
                answer[i] = x;
        }
        return answer;
    }
}

class Solution
{
    public int[] findBall(int[][] grid)
    {
        int[] answer = new int[grid[0].length];
        for(int i =0;i<answer.length; i++)
        {
            int x= i, y= 0;
            while(y<grid.length)
            {
                if(grid[y][x] == 1)
                {
                    if(x+1==answer.length||grid[y][x+1] == -1)
                    {
                        answer[i] = -1;
                        break;
                    }
                    else
                    {
                        x+=1;
                        y+=1;
                    }
                }
                else
                {
                    if(x==0||grid[y][x-1] == -1)
                    {
                        answer[i] = -1;
                        break;
                    }
                    else
                    {
                        x-=1;
                        y+=1;
                    }
                }
            }
            if(answer[i]!=-1)
            answer[i] = x;
        }
    }
}

class Solution
{
    public int[] findBall(int[][] grid)
    {
        int[] answer = new int[grid[0].length];
        for(int i=0;i<answer.length;i++)
        {
            int x = i, y= 0;
            while(y<grid.length)
            {
                if(grid[y][x]==1)
                {
                    if(x+1==answer.length || grid[y][x+1] == -1)
                    {
                        answer[i] = -1;
                        break;
                    }
                    else
                    {
                        x+=1;
                        y+=1;
                    }
                }
                else
                {
                    if(x==0||grid[y][x-1] == 0)
                    {
                        answer[i] = -1;
                        break;
                    }
                    else
                    {
                        x-=1;
                        y+=1;
                    }
                }
            }
            if(answer[i]!=-1)
            answer[i] = x;
        }
        return answer;
    }
}