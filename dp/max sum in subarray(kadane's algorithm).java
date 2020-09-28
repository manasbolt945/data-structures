class Solution {
    public int maxSubArray(int[] nums)
    {
        int sum=0,maxl=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            maxl = Math.max(sum,maxl);
            if(sum<0)
               sum=0; 
            
        }
        return maxl;
    }
}
