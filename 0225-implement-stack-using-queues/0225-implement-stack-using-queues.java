class MyStack {

    Queue<Integer> u;
    public MyStack() {
        u=new LinkedList<>();
    }
    
    public void push(int x) {
        u.add(x);

        for(int i=0;i<u.size()-1;i++) u.add(u.remove());
    }
    
    public int pop() {
        return u.poll();
    }
    
    public int top() {
        return u.peek();
    }
    
    public boolean empty() {
        return u.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */