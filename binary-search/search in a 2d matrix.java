class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
            
        for(int p[] :matrix)
        {
            if(p[0]==target || p[p.length-1]==target)
                return true;
             if(p[0]<target && p[p.length-1]>target)
                return binary(p,target);
        }
        return false;
    }
    public boolean binary(int arr[], int target)
    {
        int l=0;
        int r = arr.length-1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]==target)
                return true;
            else if(arr[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
}
