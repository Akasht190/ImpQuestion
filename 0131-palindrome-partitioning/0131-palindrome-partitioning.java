class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        helper(s,0,result,temp);
        return result;
    }

    public void helper(String s,int ind,List<List<String>> result,List<String> temp){
         if(ind==s.length()){
            result.add(new ArrayList<>(temp));
         }

         for(int i=ind;i<s.length();i++){
            String newString =s.substring(ind,i+1);
            if(isPalindrome(newString)){
                temp.add(newString);
                helper(s,i+1,result,temp);
                temp.remove(temp.size()-1);
            }
            else{
                continue;
            }
         }
    }

    public boolean isPalindrome(String s){
       if(s==null){
          return false;
       }
       int left=0;
       int right=s.length()-1;
       while(left<right){
          if(s.charAt(left)!=s.charAt(right)){
               return false;
          }
          left++;
          right--;
       }
       return true;
    }

}
