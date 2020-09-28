class Solution {
    public void setZeroes(int[][] matrix)
    {
        int dummy[][] = new int[matrix.length][matrix[0].length];
        int max=Integer.MAX_VALUE;
        int i=0,j=0;
        int n=matrix[0].length;
        while(j<n)
        {
            if(matrix[i][j]==0)
            {
                for(int k=0; k<matrix.length; k++)
                    dummy[k][j]=max;
                for(int k=0; k<matrix[i].length; k++)
                    dummy[i][k]=max;
            }
            if(i==matrix.length-1)
            {
                i=0;
                j++;
                continue;
            }
            i++;
        }
        for(int f=0; f<matrix.length; f++)
        {
            for(int l=0; l<matrix[f].length; l++)
            {
                if(dummy[f][l]==max)
                    matrix[f][l]=0;
            }
        }
    }
   
}
