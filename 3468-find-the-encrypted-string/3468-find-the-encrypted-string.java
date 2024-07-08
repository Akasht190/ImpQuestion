class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder encyptedString=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            int j=(i+k)%n;
            encyptedString.append(s.charAt(j));
        }
        return encyptedString.toString();
    }
}