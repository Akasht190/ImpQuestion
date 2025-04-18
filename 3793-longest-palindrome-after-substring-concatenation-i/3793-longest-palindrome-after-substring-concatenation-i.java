class Solution {
    public int longestPalindrome(String s, String t) {
        int ans=0;
        int n=s.length();
        int m=t.length();

        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                 String str1=s.substring(i,j);

                 for(int k=0;k<=m;k++){
                    for(int l=k;l<=m;l++){
                       String str2=t.substring(k,l);

                       String c=str1+str2;

                       if(isPalindrome(c)){
                          ans=Math.max(ans,c.length());
                       }
                    }
                 }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}