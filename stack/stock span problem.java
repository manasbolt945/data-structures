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
		    String str[] = br.readLine().split(" ");
		    int j=0;
		    int a[] = new int[n];
		    for(String g:str)
		    a[j++] = Integer.parseInt(g);
		    Stack<Integer> s = new Stack<Integer>();
		    s.push(0);
		    ArrayList<Integer> arr = new ArrayList<Integer>();
		    arr.add(1);
		    for(int i=1; i<n ;i++)
		    {
		        while(!s.isEmpty() && a[s.peek()]<=a[i])
		        s.pop();
		        if(s.isEmpty())
		        arr.add(i+1);
		        else
		        arr.add(i-s.peek());
		        s.push(i);
		    }
		    for(Integer i:arr)
		    {
		        System.out.print(i+" ");
		        
		    }
		    System.out.println();
		}
		
	}
}
