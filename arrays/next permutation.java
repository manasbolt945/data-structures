class Solution {
    public void nextPermutation(int[] nums) 
    {
      int m=-1;
        int n= nums.length;
        for(int i=n-1; i>0; i--)
        {
            if(nums[i]>nums[i-1])
            {
                m = i-1;
                break;
            }
        }
        if(m==-1)
        {
            Arrays.sort(nums);
            return;
        }
        int ind=0;
        for(int i=n-1; i>=m+1; i--)
        {
            if(nums[i]>nums[m])
            {
                ind = i;
                break;
            }
        }
        int temp = nums[m];
        nums[m]=nums[ind];
        nums[ind]=temp;
        swap(nums,m+1,n-1);
    }
    public void swap(int nums[], int j, int k)
    {
        while(j<k)
        {
            int t = nums[j];
            nums[j]=nums[k];
            nums[k]=t;
            j++;
            k--;
        }
    }
}
