class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        for(int i=0; i<numCourses; i++)
            arr.add(new ArrayList<Integer>());
        for(int[] pre : prerequisites)
            arr.get(pre[0]).add(pre[1]);
        Stack<Integer> s = new Stack();
        boolean v[] = new boolean[numCourses];
        boolean rect[] = new boolean[numCourses];
        int flag=0;
        for(int i=0; i<numCourses; i++)
        {
            if(!v[i])
                if(dfs(arr,i,v,rect,s))
                {
                    flag=1;
                    break;
                }
        }
        if(flag==1)
        {
            return new int[0];
        }
        else
        {
            int x = s.size();
            int ar[] = new int[x];
            
            for(int i=0; i<x; i++)
            {
                ar[x-1-i]=s.pop();
            }
            return ar;
        }
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean v[],boolean rect[],Stack<Integer> s1)
    {
        v[s]=true;
        rect[s]=true;
        for(int i: adj.get(s))
        {
            if(!v[i] && dfs(adj,i,v,rect,s1))
                return true;
            else if(rect[i])
                return true;
        }
        rect[s]=false;
        s1.push(s);
        return false;
    }
}
