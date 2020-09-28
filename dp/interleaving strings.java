public class Solution {
    public int isInterleave(String A, String B, String C)
    {
        int n = getLCS(A,C);
        int m = getLCS(B,C);
        if(n==A.length() && m==B.length())
        return 1;
        return 0;
    }
    public int getLCS(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
