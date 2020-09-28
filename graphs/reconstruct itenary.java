class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        ArrayList<Integer> arr = new ArrayList();
        if(n==1)
        {
            arr.add(0);
            return arr;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        int degree[] = new int[n];
        for(int[] key: edges)
        {
            adj.get(key[0]).add(key[1]);
            adj.get(key[1]).add(key[0]);
            degree[key[0]]++;
            degree[key[1]]++;
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<n; i++)
        {
            if(degree[i]==1)
                q.add(i);
        }
        int numleft=n;
        while(!q.isEmpty())
        {
            if(numleft<=2)
                break;
            int size = q.size();
            while(size-->0)
            {
            int u = q.poll();
            numleft--;
            for(int v: adj.get(u))
            {
                degree[v]--;
                if(degree[v]==1)
                    q.add(v);
            }
        }
        }
         arr.addAll(q);
        return arr;
    }
}
