class Solution {
    public int maximalRectangle(char[][] matrix) 
    {
        int m = matrix.length;
        if(matrix.length==0)
            return 0;
        int n = matrix[0].length;
        int rect[][] = new int[m][n];
        for(int j=0; j<matrix[0].length; j++)
        {
            if(matrix[0][j]=='1')
                rect[0][j]=1;
        }
        int max=maxarea(rect[0]);
       for(int i=1; i<matrix.length; i++)
       {
           for(int j=0; j<n; j++)
           {
               rect[i][j] = matrix[i][j]=='1'?rect[i-1][j]+1:0;
           }
           max= Math.max(maxarea(rect[i]),max);
       }
        return max;
    }
    public int maxarea(int rect[])
    {
        int n = rect.length;
        int left[]  = new int[n];
        int right[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<n; i++)
        {
            if(s.isEmpty())
                left[i]=-1;
            else
            {
                if(rect[s.peek()]<rect[i])
                    left[i]=s.peek();
                else
                {
                    while(!s.isEmpty() && rect[s.peek()]>=rect[i])
                        s.pop();
                    if(s.isEmpty())
                        left[i]=-1;
                    else
                        left[i]=s.peek();
                }
            }
            s.push(i);
        }
        s.clear();
        for(int i=n-1; i>=0; i--)
        {
            if(s.isEmpty())
                right[i]=n;
            else
            {
                if(rect[s.peek()]<rect[i])
                    right[i]=s.peek();
                else
                {
                    while(!s.isEmpty() && rect[s.peek()]>=rect[i])
                        s.pop();
                    if(s.isEmpty())
                        right[i]=n;
                    else
                        right[i]=s.peek();
                }
            }
            s.push(i);
        }
        int max=0;
        for(int i=0; i<n; i++)
        {
            int area = (right[i]-left[i]-1)*rect[i];
            max = Math.max(area,max);
        }
        return max;
    }
}
