/*package whatever //do not write package name here */
//GeeksforGeeks question
//Brilliant Solution
//Very Very Important.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().split(" ");
		    int k = Integer.parseInt(br.readLine());
		    int arr[]=  new int[n];
		    for(int i=0; i<n; i++)
		    arr[i] = Integer.parseInt(str[i]);
		    long l=0,r=0;
		    for(int i=0; i<n; i++)
		    {
		        l = Math.max(l,arr[i]);
		        r+=arr[i];
		    }
		    long ans=-1;
		    while(l<=r)
		    {
		      long mid = l+(r-l)/2;
		      if(isValid(arr,mid,k))
		      {
		          ans = mid;
		          r = mid-1;
		      }
		      else
		      l = mid+1;
		    }
		    if(n<k)
		    System.out.println("-1");
		    else
		    System.out.println(ans);
		}
	}
	public static boolean isValid(int arr[], long maxP, int k)
	{
	    int st=1;
	    long sum=0;
	    for(int i=0; i<arr.length; i++)
	    {
	        sum+=arr[i];
	        if(sum>maxP)
	        {
	            st++;
	            sum = arr[i];
	        }
	        if(st>k)return false;
	    }
	    return true;
	}
}
