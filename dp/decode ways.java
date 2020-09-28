class Solution {
    int dp[];
    public int numDecodings(String s) 
    {
        int n = s.length();
        if(s.length()==1 && s.charAt(0)=='0')
            return 0;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return countDecoding(s.toCharArray(),n);
    }
     int countDecoding(char[] digits, int n) 
{  
	if (n == 0 || n == 1) 
	return 1; 

	if (digits[0]=='0') 
		return 0; 
    if(dp[n]!=-1)
    return dp[n];
 
	int count = 0; 

	 
	if (digits[n - 1] > '0') 
	count = countDecoding(digits, n - 1); 

	
	if (digits[n - 2] == '1' || 
	(digits[n - 2] == '2' && digits[n - 1] < '7')) 
	count += countDecoding(digits, n - 2); 

	return dp[n]= count; 
}
}
