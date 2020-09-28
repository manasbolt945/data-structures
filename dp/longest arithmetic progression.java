public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) 
    {
        int n = A.length;
        int lap[] = new int[n];
        Arrays.fill(lap,2);
        int ans=2;
        Arrays.sort(A);
        for(int i=n-2; i>=0; i--)
        {
            int j = i-1;
            int k = i+1;
            
            while(j>=0 && k<n)
            {
                if(A[j]+A[k]==2*A[i])
                {
                    lap[i] = Math.max(lap[k]+1,lap[i]);
                    ans = Math.max(ans,lap[i]);
                    i--;
                    k++;
                }
                else if(A[j]+A[k] < 2*A[i] )
                k++;
                else
                j--;
            }
        }
        return ans;
    }
}
