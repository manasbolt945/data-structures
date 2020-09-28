/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    char str[] = br.readLine().toCharArray();
		    int dp[] = new int[n+1];
		    dp[0]=0;
		    dp[1]=1;
		    for(int i=2; i<=n; i++)
		    {
		        if(str[i-1]!=str[i-2])
		        dp[i] =4+dp[i-2];
		        else
		        dp[i] =Math.max(dp[i-1]+1,3+dp[i-2]);
		    }
		    System.out.println(dp[n]);
		}
	}
	
}