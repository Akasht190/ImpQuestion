class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int count=1;
        for(int i=1;i<s.length();i++,count++){
            if(s.charAt(i-1)!=s.charAt(i) && count==k) return true;
            if(s.charAt(i-1)!=s.charAt(i)) count=0;
        }
        return (count==k);
    }
}