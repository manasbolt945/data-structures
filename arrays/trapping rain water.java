/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().split(" ");
		    int j=0;
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++)
		    arr[i] = Integer.parseInt(str[i]);
		    
		   System.out.println(trapWater(arr));
		    
		}
	}
	public static int trapWater(int arr[])
	{
	    int n = arr.length;
	    int left[] = new int[n];
	    int right[] = new int[n];
	    left[0] = arr[0];
	    for(int i=1; i<arr.length; i++)
	    left[i] = Math.max(arr[i],left[i-1]);
	    right[n-1] = arr[n-1];
	    for(int i=n-2; i>=0; i--)
	    right[i] = Math.max(arr[i],right[i+1]);
	    int sum=0;
	    for(int i=0; i<n; i++)
	    {
	        sum+= Math.min(left[i],right[i])-arr[i];
	    }
	    return sum;
	}
}
