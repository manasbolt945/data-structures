class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) 
    {
       int n = triangle.size();
        dp = new int[n][n];
        for(int p[]: dp)
            Arrays.fill(p,-1);
        return tri(triangle,0,0);
    }
    public int tri(List<List<Integer>> triangle, int i, int j)
    {
        if(i>=triangle.size() || j>=triangle.size())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int x = triangle.get(i).get(j)+tri(triangle,i+1,j);
        int y = triangle.get(i).get(j)+tri(triangle,i+1,j+1);
        return dp[i][j] = Math.min(x,y);
    }
}
