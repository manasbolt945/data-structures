class Solution {
    int count;
    public int maxAreaOfIsland(int[][] grid)
    {
        int max=0;
        if(grid.length==0 || grid[0].length==0)
            return 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                count=0;
                if(grid[i][j]==1)
                {
                    dfs(grid,i,j);
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }
    public void dfs(int grid[][], int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
            return;
        count++;
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
