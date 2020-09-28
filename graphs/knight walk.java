/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    //static int res=Integer.MAX_VALUE;
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String s[] = br.readLine().split(" ");
		   int m = Integer.parseInt(s[0]);
		   int n = Integer.parseInt(s[1]);
		   StringTokenizer str = new StringTokenizer(br.readLine());
		   int s1 = Integer.parseInt(str.nextToken());
		   int s2 = Integer.parseInt(str.nextToken());
		   int d1 = Integer.parseInt(str.nextToken());
		   int d2 = Integer.parseInt(str.nextToken());
		   int board[][] = new int[m][n];
		   for(int i=0; i<m; i++)
		   {
		       Arrays.fill(board[i],Integer.MAX_VALUE);
		   }
		   int res[] = new int[1];
		   res[0]=Integer.MAX_VALUE;
		   dfs(board,m,n,s1-1,s2-1,d1-1,d2-1,0,res);
		   if(res[0]==Integer.MAX_VALUE)
		   System.out.println("-1");
		   else
		   System.out.println(res[0]);
		    
		}
	}
	public static void dfs(int board[][],int m,int n,int i, int j, int d1, int d2,int curr,int res[])
	{
	    if(i<0 || j<0 || i>=m || j>=n|| board[i][j]<=curr)
	    return;
	    if(i==d1 && j==d2)
	    {
	    res[0]= Math.min(res[0],curr);
	    return;
	    }
	    board[i][j]=curr;
	    dfs(board,m,n,i-2,j+1,d1,d2,curr+1,res);
	    dfs(board,m,n,i-1,j+2,d1,d2,curr+1,res);
	    dfs(board,m,n,i+1,j+2,d1,d2,curr+1,res);
	    dfs(board,m,n,i+2,j+1,d1,d2,curr+1,res);
	    dfs(board,m,n,i+2,j-1,d1,d2,curr+1,res);
	    dfs(board,m,n,i+1,j-2,d1,d2,curr+1,res);
	    dfs(board,m,n,i-1,j-2,d1,d2,curr+1,res);
	    dfs(board,m,n,i-2,j-1,d1,d2,curr+1,res);
	  
	}
}
