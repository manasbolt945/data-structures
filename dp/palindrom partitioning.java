class Solution {
    int dp[][];
    public int minCut(String s) 
    {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] p: dp)
            Arrays.fill(p,-1);
        return minPar(s,0,n-1);
    }
    public int minPar(String str, int i, int j)
    {
        if(i>=j)
            return 0;
        if(isPalin(str,i,j))
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left=0,right=0,ans=Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
        {
            if(dp[i][k]!=-1)
                left = dp[i][k];
            else
            {
                left = minPar(str,i,k);
                dp[i][k] = left;
            }
            if(dp[k+1][j]!=-1)
                right = dp[k+1][j];
            else
            {
                right = minPar(str,k+1,j);
                dp[k+1][j]= right;
            }
            int temp = left+right+1;
            ans = Math.min(temp,ans);
        }
        return dp[i][j]=ans;
    }
    public boolean isPalin(String str, int i, int j)
    {
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
