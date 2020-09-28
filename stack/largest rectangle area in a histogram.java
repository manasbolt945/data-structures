class Solution {
    public int largestRectangleArea(int[] height) 
    {
        int n =height.length;
        int li[] = new int[n];
        int ri[] = new int[n];
        Stack<Integer> s1 = new Stack();
        //Stack<Integer> s2 = new Stack();
        for(int i=0; i<height.length; i++)
        {
            if(s1.isEmpty())
                li[i]=-1;
            else
            {
                if(height[s1.peek()]<height[i])
                    li[i] = s1.peek();
                else
                {
                    while(!s1.isEmpty() && height[i]<=height[s1.peek()])
                        s1.pop();
                    if(s1.isEmpty())
                        li[i] = -1;
                    else
                        li[i]=s1.peek();
                }
            }
            s1.push(i);
        }
        s1.clear();
        for(int i=n-1; i>=0; i--)
        {
            if(s1.isEmpty())
                ri[i]=n;
             else
            {
                if(height[s1.peek()]<height[i])
                    ri[i] = s1.peek();
                else
                {
                    while(!s1.isEmpty() && height[i]<=height[s1.peek()])
                        s1.pop();
                    if(s1.isEmpty())
                        ri[i] = n;
                    else
                        ri[i]=s1.peek();
                }
            }
            s1.push(i);
        }
        int max=0;
        for(int i=0; i<n; i++)
        {
            int area = (ri[i]-li[i]-1)*height[i];
            max = Math.max(area,max);
        }
        return max;
    }
    
}
