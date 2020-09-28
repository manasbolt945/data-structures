class Solution {
    int dp[][];
    public int minPathSum(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i<=0 && j<=0)
                    continue;
                else if(i==0)
                    grid[0][j]+=grid[0][j-1];
                else if(j==0)
                    grid[i][0]+=grid[i-1][0];
                else
                {
                int x= grid[i-1][j];
                int y = grid[i][j-1];
                grid[i][j] = grid[i][j]+Math.min(x,y);
                }
            }
        }
        return grid[m-1][n-1];
    }
   
}
