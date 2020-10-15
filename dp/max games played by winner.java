/*There are N players which are playing a tournament.
We need to find the maximum number of games the winner can play. In this tournament, 
two players are allowed to play against each other only if the difference between games played by them is not more than one*/
import java.util.*;
class TestClass {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);


        // Write your code here
        int n = sc.nextInt();
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int i = 2;
        do
        {
            dp[i] = dp[i-1]+dp[i-2];
            i++;
        }while(dp[i]<=n);
        System.out.println(i-1);

    }
}
