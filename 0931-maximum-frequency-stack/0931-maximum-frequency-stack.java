class FreqStack {
    HashMap<Integer,Integer> freqMap=new HashMap<>();
    HashMap<Integer,Stack<Integer>> freqSt=new HashMap<>();
    int maxFreq=0;

    public FreqStack() {
        freqMap=new HashMap<>();
        freqSt=new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int maxF=freqMap.getOrDefault(val,0)+1;
        freqMap.put(val,maxF);
        if(maxF>maxFreq){
            maxFreq=maxF;
        }
        freqSt.computeIfAbsent(maxF,f->new Stack()).push(val);
    }
    
    public int pop() {
        Stack<Integer> st=freqSt.get(maxFreq);
        int top=st.pop();
        if(st.isEmpty()) maxFreq--;
        freqMap.put(top,freqMap.get(top)-1);
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */