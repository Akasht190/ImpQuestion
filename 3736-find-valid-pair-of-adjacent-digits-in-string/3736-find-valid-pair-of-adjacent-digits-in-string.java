class Solution {
    public String findValidPair(String s) {
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        String ans="";
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))==s.charAt(i)-'0'){
                res.append(s.charAt(i));
                if(res.length()==2 && res.charAt(0)!=res.charAt(1)){
                    return res.toString();
                }
                if(res.length()==2 && res.charAt(0)==res.charAt(1)){
                    res.deleteCharAt(0);
                }
            }
            else{
                res=new StringBuilder();
            }
        }
        return ans;
    }
}