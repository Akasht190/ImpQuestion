class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!hm1.containsKey(s.charAt(i))){
                hm1.put(s.charAt(i),i);
            }

            if(!hm2.containsKey(t.charAt(i))){
                hm2.put(t.charAt(i),i);
            }

            if(!hm1.get(s.charAt(i)).equals(hm2.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
        
    }
}