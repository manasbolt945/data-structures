class Solution {
    //int[] ans;
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) 
    {
       
       int ans[] = new int[2];
         parent = new int[edges.length+1];
         rank = new int[edges.length+1];
        for(int i=0;i<=edges.length; i++)
        {
            parent[i]=i;
        }
        for(int key[] : edges)
        {
            int x = find(key[0]);
            int y = find(key[1]);
            if(x!=y)
            {
                union(x,y);
                
            }
            else
            {
                ans[0]=key[0];
                ans[1]=key[1];
            }
        }
        return ans;
    }
    public int find(int x)
    {
        if(parent[x]==x)
            return x;
      return find(parent[x]);
        
    }
    public void union(int x, int y)
    {
        int xrep = find(x);
        int yrep = find(y);
        if(rank[xrep]<rank[yrep])
            parent[xrep]=yrep;
        else if(rank[xrep]>rank[yrep])
            parent[yrep]=xrep;
        else
        {
            parent[yrep]=xrep;
            rank[xrep]++;
            
        }
    }
   
}
