/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int dp[][] = new int[1001][1001];
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n =Integer.parseInt(br.readLine());
		    int arr[][] = new int[n][n];
		    String str[] = br.readLine().split(" ");
		    int g=0;
		    for(int i=0; i<n; i++)
		    {
		        for(int j=0; j<n; j++)
		        arr[i][j] = Integer.parseInt(str[g++]);
		    }
		    for(int i=0; i<n; i++)
		    {
		        for(int j=0; j<n;j++)
		        dp[i][j]=-1;
		    }
		    int res=0;
		    for(int j=0; j<n; j++)
		    res = Math.max(res,zigzag(arr,0,j,n));
		    System.out.println(res);

		    
		}
	}
	static int zigzag(int arr[][], int i, int j,int n)
	{
	    if(dp[i][j]!=-1)
	    return dp[i][j];
	    if(i==n-1)
	    return dp[i][j]=arr[i][j];
	    int res=0;
	    for(int k=0; k<n; k++)
	    {
	        if(k!=j)
	        res = Math.max(res,zigzag(arr,i+1,k,n));
	    }
	    return dp[i][j]=res+arr[i][j];
	}
}