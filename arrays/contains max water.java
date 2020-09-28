class Solution {
    public int maxArea(int[] height) 
    {
        int n= height.length;
        int area=0;
        int j=0,k=n-1;
        while(j<k)
        {
            
            area = Math.max(area, Math.min(height[k],height[j])*(k-j));
            if(height[j]<height[k])j++;
            else
                k--;
        }
        return area;
    }
   
}
