class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int a,b=0;

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                a=st.pop();
                b=st.pop();
                st.push(a+b);
            }

            else if(tokens[i].equals("-")){
                a=st.pop();
                b=st.pop();
                st.push(b-a);
            }

            else if(tokens[i].equals("/")){
                a=st.pop();
                b=st.pop();
                st.push(b/a);
            }
            else if(tokens[i].equals("*")){
                a=st.pop();
                b=st.pop();
                st.push(a*b);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}