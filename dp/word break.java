class Solution {
    boolean dp[][] = new boolean[1001][1001];
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n = s.length();
        boolean dp[]= new boolean[n+1];
        dp[0]=true;
        int max=0;
        for(String str: wordDict)
            max = Math.max(max,str.length());
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(j-i>max)
                    continue;
                if(dp[j] && wordDict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
