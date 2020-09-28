class Solution {
    public int[][] merge(int[][] intervals) 
    {
        if(intervals.length==0)
        {
            int arr[][] = new int[0][0];
            return arr;
        }
       Arrays.sort(intervals,new Comparator<int[]>(){
           public int compare(int a[], int b[])
           {
               return a[0]-b[0];
           }
       });
      Stack<ArrayList<Integer>> s = new Stack();
        ArrayList<Integer> a = new ArrayList();
        a.add(intervals[0][0]);
        a.add(intervals[0][1]);
        s.push(a);
        for(int i=1; i<intervals.length; i++)
        {
            ArrayList<Integer> adj = new ArrayList();
            if(s.peek().get(1)<intervals[i][0])
            {
                adj.add(intervals[i][0]);
                adj.add(intervals[i][1]);
                s.push(adj);
            }
            else if(s.peek().get(1)<intervals[i][1])
            {
                ArrayList<Integer> as= s.pop();
                adj.add(as.get(0));
                adj.add(intervals[i][1]);
                s.push(adj);
            }
        }
        int arr[][] = new int[s.size()][2];
        for(int i=arr.length-1; i>=0; i--)
        {
            int ab[] = new int[2];
            ab[0] = s.peek().get(0);
            ab[1] = s.peek().get(1);
            arr[i] = ab;
            s.pop();
        }
        return arr;
    }
}
