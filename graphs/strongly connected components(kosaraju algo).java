// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());
            
            for(int i =0; i < vertices; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edges; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 list.get(u).add(v);
            }
            
            Solution T = new Solution();
            System.out.println(T.kosaraju(list, vertices));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// N: No of vertices
class Solution
{
    public void DFS(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, List<Integer> comp) 
    {
        visited[v] = true;
        for (int i = 0; i < graph.get(v).size(); i++)

            if (!visited[graph.get(v).get(i)])
                DFS(graph, graph.get(v).get(i), visited, comp);

        comp.add(v);
    }
    public List<Integer> fillOrder(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int N) 
    {        

        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)

            if (!visited[i])DFS(graph, i, visited, order);

        return order;
    }
    public ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> graph, int N)
    {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++)
            g.add(i, new ArrayList<Integer>());
        for (int v = 0; v < N; v++)
            for (int i = 0; i < graph.get(v).size(); i++)
                g.get(graph.get(v).get(i)).add(v);

        return g;
        
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> list, int N)
    {
        boolean[] visited = new boolean[N];
        List<Integer> order = fillOrder(list, visited, N);       
        ArrayList<ArrayList<Integer>> reverseGraph = getTranspose(list, N);        
        visited = new boolean[N];
        Collections.reverse(order);
        List<List<Integer>> SCC = new ArrayList<>();
        for (int i = 0; i < order.size(); i++)
        {
            int v = order.get(i);
            if (!visited[v]) 
            {
                List<Integer> comp = new ArrayList<>();
                DFS(reverseGraph, v, visited, comp);
                SCC.add(comp);
            }
        }
        
        return SCC.size();
    }
}
