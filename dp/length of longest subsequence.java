public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestSubsequenceLength(final int[] A) 
    {
        int n = A.length;
        int lis[] = new int[n];
        int lps[] = new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lps,1);
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(A[i]>A[j])
                lis[i] = Math.max(lis[i],lis[j]+1);
            }
        }
        for(int i=n-2; i>=0; i--)
        {
            for(int j=n-1; j>i; j--)
            {
                if(A[i]>A[j])
                lps[i] = Math.max(lps[i],1+lps[j]);
            }
        }
        int max=0;
        for(int i=0; i<n; i++)
        max = Math.max(max,lis[i]+lps[i]-1);
        return max;
    }
}
