class Solution {
    public int strStr(String haystack, String needle) {
       if(haystack.length()==needle.length()){
           if(haystack.equals(needle)){
                return 0;
           }
       }
       int i=0;
       int j=needle.length();

       while(j<=haystack.length()){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
            i++;
            j++;
       }
       return -1;
    }
}