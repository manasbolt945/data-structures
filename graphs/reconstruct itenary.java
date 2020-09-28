class Solution {
    Map<String, PriorityQueue<String>> hm;
    LinkedList<String> path;
    
    public List<String> findItinerary(List<List<String>> tickets) 
    {
       hm = new HashMap();
        path = new LinkedList();
        for(List<String> tik : tickets)
        {
            hm.putIfAbsent(tik.get(0),new PriorityQueue());
            hm.get(tik.get(0)).add(tik.get(1));
        }
         dfs("JFK");
        return path;
    }
    public void dfs(String dept)
    {
        PriorityQueue<String> abs = hm.get(dept);
        while(abs!=null && !abs.isEmpty())
        {
            //String temp = abs.poll();
            dfs(abs.poll());
        }
        path.addFirst(dept);
    }
}
