class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<Integer>());
        for(int[] pre : prerequisites)
            adj.get(pre[0]).add(pre[1]);
        boolean visited[] = new boolean[numCourses];
        boolean rect[] = new boolean[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
                if(dfs(i,adj, visited,rect))
                    return false;
        }
        return true;
    }
    public boolean dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean rect[])
    {
        
        visited[s]=true;
        rect[s]=true;
        for(int i: adj.get(s))
        {
            if(!visited[i] && dfs(i,adj,visited,rect))
                return true;
            else if(rect[i])
                return true;
        }
        rect[s]=false;
        return false;
    }
}
