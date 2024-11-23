class Solution {
    public String reverseWords(String s) {
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        StringBuilder result=new StringBuilder();

        s=s.trim();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)==' ' && s.charAt(i+1)!=' '){
                st.push(sb.toString());
                sb.setLength(0);
            }
        }

        st.push(sb.toString());
        while(st.size()>1){
            result.append(st.pop()+' ');
        }
        result.append(st.pop());
        return result.toString();
    }
}