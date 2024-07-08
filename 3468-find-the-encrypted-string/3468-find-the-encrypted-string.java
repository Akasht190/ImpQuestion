class Solution {
    public String getEncryptedString(String s, int k) {
       StringBuilder str=new StringBuilder();
       for(int i=0;i<s.length();i++){
          int j=(i+k)%s.length();
          str.append(s.charAt(j));
       }
       return str.toString();
    }
}