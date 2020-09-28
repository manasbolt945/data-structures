class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) 
    {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        for(int p[] : dp)
            Arrays.fill(p,-1);
        return minD(word1,word2,m,n);
    }
    public int minD(String str1, String str2, int n, int m)
    {
        if(n==0)return m;
        if(m==0)return n;
        if(dp[n][m]!=-1)
        return dp[n][m];
        int x=0,y=0,z=0;
        if(str1.charAt(n-1)==str2.charAt(m-1))
        return dp[n][m] = minD(str1,str2,n-1,m-1);
        if(str1.charAt(n-1)!=str2.charAt(m-1))
        {
            x = minD(str1,str2,n-1,m);
            y = minD(str1,str2,n-1,m-1);
            z = minD(str1,str2,n,m-1);
        }
        return dp[n][m] = 1+ Math.min(x,Math.min(y,z));
    }
}
