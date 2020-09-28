class Solution {
    public int firstMissingPositive(int[] nums) 
    {
        if(nums.length==0)
            return 1;
       
        Arrays.sort(nums);
        int j=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>=0)
            {
                j=i;
                break;
            }
            
        }
        int prev = nums[j];
        if(prev<0)
            return 1;
        if(j==nums.length-1)
        {
            if(nums[j]>1)
                return 1;
            else
                return nums[j]+1;
        }
        if(nums[j]>1)
            return 1;
        int ans=0;
        int flag=0;
        
        
        for(int i=j+1; i<nums.length; i++)
        {
            if(nums[i]-prev<=1)
            {
                prev = nums[i];
                flag=1;
            }
            else
            {
                flag=0;
                break;
            }
            
        }
        if(nums[0]>1)
            return 1;
        else if(flag==1)
            return nums[nums.length-1]+1;
        else
            return prev+1;
        
            
        
    }
}
