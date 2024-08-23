class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(st.size()==0){
                st.push(ch);
            }

            else if(st.peek()==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder ch1=new StringBuilder();
        while(st.size()>0){
            char ch2=st.peek();
            st.pop();
            ch1.append(ch2);
        }
        return ch1.toString();
    }
}