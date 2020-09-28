class Solution {
    int dp[][];
    public int superEggDrop(int K, int N)
    {
        dp = new int[K+1][N+1];
        for(int p[] :dp)
            Arrays.fill(p,-1);
        return egg(K,N);
    }
    public int egg(int e, int f)
    {
        
        if(e==1)return f;
        if(f==0 || f==1)return f;
        if(dp[e][f]!=-1)return dp[e][f];
        int min= Integer.MAX_VALUE;
        for(int k=1; k<=f; k++)
        {
            int l,r;
            if(dp[e-1][k-1]!=-1)
                l= dp[e-1][k-1];
            else
            {
                l = egg(e-1,k-1);
                dp[e-1][k-1]=l;
            }
            if(dp[e][f-k]!=-1)
                r=dp[e][f-k];
            else
            {
                r= egg(e,f-k);
                dp[e][f-k]=r;
            }
            int temp =1+ Math.max(l,r);
            min = Math.min(min,temp);
        }
        return dp[e][f]=min;
    }
}
