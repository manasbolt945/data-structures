class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s = new Stack();
    Stack<Integer> m = new Stack();
    public MinStack() {
    }
    
    public void push(int x)
    {
        s.push(x);
        if(m.isEmpty() || x<=m.peek())
        {
            m.push(x);
            return;
        }
    }
    
    public void pop() {
        int ans = s.peek();
        s.pop();
        if(ans==m.peek())
            m.pop();
        
        
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        if(m.isEmpty())
            return 0;
        return m.peek();
        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
