class Solution {
    int dp[][];
    public int numDistinct(String s, String t) 
    {
        int m = s.length();
        int n = t.length();
        dp = new int[m+1][n+1];
        for(int p[]: dp)
            Arrays.fill(p,-1);
        return dist(s,t,m,n);
    }
    public int dist(String str1, String str2, int m, int n)
    {
        
        if(m==0 && n==0)
            return 1;
        if(m==0)
            return 0;
        if(n==0)
            return 1;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int ans;
        if(str1.charAt(m-1)!=str2.charAt(n-1))
            ans= dist(str1,str2,m-1,n);
        else
        ans = dist(str1,str2,m-1,n-1)+dist(str1,str2,m-1,n);
        return dp[m][n]=ans;

    }
}
