import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		  int n = Integer.parseInt(br.readLine());
	    int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		  minCoins(n,coins);
		 
		}
	}
	
	static void minCoins(int n,int coins[])
	{
	    //Top x-axis -> amount from 0..to n          //DRAW GRAPH.
	    //Y-axis -> coins from 1,2,5...2000 
	    int dp[][] = new int[coins.length][n+1];
	    
	    //If amount = 0 => then all coins needed =0.
	    //So first column is all zero.
	    
	    //If coin=1 => then amount = same amount (as no change provided)
	    //So first row is equal to corresponding amount.
	    for(int i=0;i<=n;i++)
	        dp[0][i]= i;
	        
	   for(int i=1;i<coins.length;i++)
	   {
	       for(int j=1;j<=n;j++)
	       {
	           //if amount is greater than or equal to the coin denomination.
	           if(j>=coins[i]) 
	            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]]+1); //Take min
	            
	            else  //dp value is equal to above cell
	            dp[i][j] = dp[i-1][j];
	       }
	   }
	   
	   //IF ONLY ASKED TO PRINT MIN OF COINS:System.out.println(dp[9][n]); 
	   
	   int i=9,j=n;  //i=no.of coins , j=amount;
	   while(i>0&&j>0)   //While 
	   {
	        //If the dp value is equal to above cell then it means it wasnt chosen 
	        // so skip it and move to next coin.
	       if(dp[i][j]==dp[i-1][j]) i--;    
	       else 
	       {System.out.print(coins[i]+" ");
	        j = j - coins[i]; }  //Subtract from the coin to get new balance amount.
	   }
	   
	   //Since we didnt consider the coin at 0th index.
	   while(j!=0){     //If the amount is still remaining.
	   System.out.print(coins[0]+" ");
	    j = j-coins[0];   }
	    
	    System.out.println();
	}
}