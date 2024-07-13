class Solution {
    List<String> ans=new ArrayList<>();
    public void generateString(String s,int n,int last){
        if(n==0){
           ans.add(s);
            return;
        }

        if(last==1){
            generateString(s+"0",n-1,0);
            generateString(s+"1",n-1,1);
        }
        else{
            generateString(s+"1",n-1,1);
        }
    }
    public List<String> validStrings(int n) {
        generateString("0",n-1,0);
        generateString("1",n-1,1);
        return ans;
    }
}