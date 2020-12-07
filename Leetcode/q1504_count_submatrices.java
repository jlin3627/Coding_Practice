/*class Solution {
    public int numSubmat(int[][] mat) 
    {
        int l = 1, r = 1;
        int ans = 0;
        while (l<=mat.length)
        {
            while (r<=mat[0].length)
            {
               for (int i = 0; i<mat.length; i++)
                {
                    for (int j = 0; j<mat[i].length;j++)
                    {
                        if (mat[i][j] == 1 && checkSquare(mat,i,j,l,r))
                        {
                            ans++;
                        }
                    }
                }
                r++;
            }
            r = 1;
            l++;
        }
        return ans;
    }
    
    public boolean checkSquare(int[][] mat, int iTst, int jTst, int l, int r)
    {
        int countL = 0, countR = 0;
        if (mat.length - iTst < l || mat[0].length - jTst < r)
        {
            return false;
        }
        for (int i = iTst; i<mat.length; i++)
        {
            if (countL >= l) break;
            for (int j = jTst; j<mat[i].length; j++)
            {
                if (countR>=r) break;
                if (mat[i][j] != 1)
                {
                    return false;
                }
                countR++;
            }
            countR = 0;
            countL++;
        }
       //String tst = String.format("w:h = %d:%d x:y = %d,%d",l,r, iTst,jTst);
        //System.out.println(tst);
        return true;
    }
}*/

/*class Solution
{
    public int numSubmat(int[][] mat)
    {
        int l = mat.length, w = mat[0].length, height[] = new int[w], res = 0;
        for (int i = 0; i<l; i++)
        {
            for (int j = 0; j<w; j++)
            {
                height[j] = mat[i][j] == 0? 0:height[j] + 1;
                for (int k = j, min = height[j]; k>= 0 && min>0;k--)
                {
                    min = Math.min(min, height[k]);
                    res += min;
                }
            }
        }
        return res;
        
    }
}*/

/*class Solution
{
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0; 
        for (int i = 0; i < m; i++) {
            Stack<int[]> st = new Stack<>();
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : (height[j] + 1);   //  height of histogram;
                int sum = 0;
                while(!st.isEmpty() && height[st.peek()[0]] >= height[j]) st.pop();
                if (!st.isEmpty()) sum += height[j] * (j - st.peek()[0]) + st.peek()[1];
                else sum += height[j] * (j + 1);
                st.push(new int[]{j, sum});
                res += sum;
            }
        }
        return res;
    }
}*/

class Solution {
    public int numSubmat(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]!=0){
                    mat[i][j]=mat[i-1][j]+1;
                }
            }
        }
        int submatric=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]!=0){
                    int min=mat[i][j];
                    submatric+=min;
                    int col=j;
                    for (int k = col + 1; k <m && mat[i][k] != 0; k++) {
						min = Math.min (min, mat[i][k]);
						submatric += min;
					}
                }
            }
        }
        return submatric;
    }
}