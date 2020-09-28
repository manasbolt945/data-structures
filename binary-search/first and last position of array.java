class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int arr[] = new int[2];
        if(binary(nums,target)<0)
        {
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        else
        {
            int j = lowerbound(nums,target);
            int k = upperbound(nums, target);
            arr[0]= j;
            arr[1] = k;
        }
        return arr;
    }
    public int binary(int arr[], int x)
    {
        int l=0;
        int r= arr.length-1;
        int mid;
        while(l<=r)
        {
            mid= (l+r)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x)
                r = mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
    public int lowerbound(int arr[],int target)
    {
        int l=0;
        int r = arr.length-1;
        int res=0;
        int mid=0;
        while(l<=r)
        {
            mid = (l+r)/2;
            if(arr[mid]==target)
            {
                res=mid;
                r=mid-1;
            }
            else if(target<arr[mid])
                r=mid-1;
            else
                l=mid+1;
        }
        return res;
    }
    public int upperbound(int arr[], int target)
    {
        int l=0;
        int r = arr.length-1;
        int res=0;
        int mid=0;
        while(l<=r)
        {
             mid = (l+r)/2;
            if(arr[mid]==target)
            {
                res=mid;
                l=mid+1;
            }
            else if(arr[mid]>target)
                r = mid-1;
            else
                l = mid+1;
         }
        return res;
    }
}
