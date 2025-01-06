class Solution {
    int ans=0;

    public int maxProduct(String s) {
        solve(s,"","",0);
        return ans;
    }


    void solve(String s,String s1,String s2,int start){
        if(start==s.length()){
            if(isPal(s1) && isPal(s2)) {
                int val=s1.length()*s2.length();
                ans=Math.max(val,ans);
            }
            return;
        }

        char ch=s.charAt(start);
        solve(s,s1+ch,s2,start+1);
        solve(s,s1,s2+ch,start+1);
        solve(s,s1,s2,start+1);
    }

    boolean isPal(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}