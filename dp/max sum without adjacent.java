public class Solution {
    public int adjacent(int[][] A)
    {
        int inc = Math.max(A[0][0],A[1][0]);
        int exc=0,excn;
        for(int i=1; i<A.length; i++)
        {
             excn = Math.max(inc,exc);
            inc= exc+ Math.max(A[0][i],A[1][i]);
            exc = excn;
        }
        return Math.max(inc,exc);
    }
}
