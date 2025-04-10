class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String w:words){
            hm.put(w,hm.getOrDefault(w,0)+1);
        }

        int res=0;
        for(String str:hm.keySet()){
            if(isSubsequence(str,s)){
                res+=hm.get(str);
            }
        }
        return res;
    }


    public boolean isSubsequence(String str1,String str2){
        int i=0;
        int j=0;
        int m=str1.length();
        int n=str2.length();
        while(i<m && j<n){
        if(str1.charAt(i)==str2.charAt(j)){
            i++;
        }
        j++;
        }

        return i==m;
    }
}