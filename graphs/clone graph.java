/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     HashMap<Node,Node> hm = new HashMap<Node,Node>();
    public Node cloneGraph(Node node) 
    {
        if(node==null)
            return node;
        Node g2 = new Node(node.val, new ArrayList<>());
       
        hm.put(node,g2);
        for(Node i : node.neighbors)
        {
            if(hm.containsKey(i))
            {
                g2.neighbors.add(hm.get(i));
            }
            else
            {
                Node temp = cloneGraph(i);
                g2.neighbors.add(temp);
            }
        }
        return g2;
        
    }
}
