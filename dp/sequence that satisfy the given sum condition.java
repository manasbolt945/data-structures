class Solution {
    public int numSubseq(int[] nums, int target) 
    {
      int mod = 1000000007;
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1; i<nums.length; i++)
            dp[i] = (2*dp[i-1])%mod;
        int j=0,k=nums.length-1;
        int ans=0;
        while(j<=k)
        {
            if(nums[j]+nums[k]<=target)
            {
                ans+= dp[k-j];
                ans%=mod;
                j++;
            }
            else
                k--;
        }
        return ans;
    }
}
