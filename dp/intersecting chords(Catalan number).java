public class Solution {
    public int chordCnt(int A) 
    {
        //CATALAN NUMBER
        long dp[] = new long[A+2];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=A; i++)
        {
            dp[i]=0;
            for(int j=0; j<i; j++)
            dp[i]+= (dp[j]*dp[i-j-1])%1000000007;
        }
        return (int)dp[A];
    }
}
