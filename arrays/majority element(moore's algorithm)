class Solution {
    public int majorityElement(int[] nums) 
    {
        int maj=nums[0];
        int c=1;
        for(int i=1; i<nums.length; i++)
        {

            if(nums[i]==maj)
                c++;
            else
                c--;
            if(c==0)
            {
                maj=nums[i];
                c=1;
            }
        }
        c=0;
        for(int n:nums)
            if(n==maj)
                c++;
        if(c>nums.length/2)
            return maj;
        else
            return 0;
      
    }
}
