// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       // add your code here
       boolean visited[] = new boolean[V];
       for(int i=0; i<V; i++)
       {
           if(!visited[i])
           if(dfs(g,i,visited,-1))
             return true;
       }
       
     return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> arr, int s, boolean visited[],int parent)
    {
        visited[s] = true;
        for(int i: arr.get(s))
        {
            if(visited[i]==false)
            {
                if(dfs(arr,i,visited,s))
                return true;
                
            }
            else if(i!=parent)
            return true;
            
        }
        return false;
    }
}
