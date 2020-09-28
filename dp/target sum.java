class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int range = 0, count = 0;
        for(int i=0;i<nums.length;i++) {
            range += nums[i];
            if(nums[i]==0){
                count = count+1;
            }
        }
        if(range<S) {
            return 0;
        }
        if((S+range)%2!=0){
            return 0;
        }
        int sum = (S + range) / 2;
        return countWaysForSum(nums, sum, count);
    }
    
    public int countWaysForSum(int[] nums, int S, int zeroes) {
        int[][] dp = new int[nums.length+1][S+1];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                if(j==0) {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(nums[i-1]==0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {   
                    if(nums[i-1] <= j) {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return (int)Math.pow(2,zeroes)*dp[nums.length][S];
    }
}
