class Solution {
    public int[] plusOne(int[] digits) 
    {
        int c=0;
        int n = digits.length;
        for(int i=n-1; i>=0; i--)
        {
            if(digits[i]==9)
            {
                digits[i]=0;
                c++;
            }
            else
            {
                
                digits[i]+=1;
                i=0;
            
             }
        }
        if(c==n)
        {
            digits = new int[n+1];
            digits[0]=1;
            for(int i=1; i<n; i++)
                digits[i]=0;
        }
        return digits;
    }
}
