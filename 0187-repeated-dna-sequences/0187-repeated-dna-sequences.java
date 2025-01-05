class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()<10){
            return ans;
        }
        int n=s.length();
        List<String> substring=new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            String substr=s.substring(i,i+10);
            substring.add(substr);
        }
         Set<String> seen=new HashSet<>();
         for(String str:substring){
              if(seen.contains(str)){
                  if(!ans.contains(str)){
                      ans.add(str);
                  }
              }
              else{
                seen.add(str);
              }
         }
         return ans;
    }
}