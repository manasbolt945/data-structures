class Solution {
    int min = Integer.MIN_VALUE;
    public int orderOfLargestPlusSign(int N, int[][] mines) 
    {
        int mat[][] = new int[N][N];
        for(int i=0; i<N; i++)
            Arrays.fill(mat[i],1);
        for(int p[]: mines)
            mat[p[0]][p[1]]=0;
        int t;
        int max=0;
        for(int i=0; i<N; i++)
        {
            if(i-max<0 || i+max>=N)continue;
            for(int j=0; j<N; j++)
            {
                t=0;
                if(j-max<0 || j+max>=N)continue;
                if(mat[i][j]==0)
                    continue;
                while(true)
                {
                    if((i-t)>=0 && (j-t)>=0 && (i+t)<N &&(j+t)<N && mat[i+t][j]==mat[i-t][j] && mat[i][j+t]==mat[i][j-t] && mat[i+t][j]==1 && mat[i][j+t]==1)
                        t++;
                    else 
                        break;
                }
                max = Math.max(max,t);
            }
        }
        return max;
    }
    
   
}
