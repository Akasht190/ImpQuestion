class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans =new ArrayList<>();

        int[] maxF=new int[26];
        for(String b:words2){
            int[] freqb=new int[26];

            for(char c:b.toCharArray()){
                freqb[c-'a']++;
            }

            for(int i=0;i<26;i++){
                maxF[i]=Math.max(maxF[i],freqb[i]);
            }
        }


        for(String a:words1){
            int[] freqa=new int[26];

            for(char c:a.toCharArray()){
                freqa[c-'a']++;
            }


            boolean flag=true;
            for(int i=0;i<26;i++){
                if(freqa[i]<maxF[i]){
                    flag=false;
                    break;
                }
            }

            if(flag) ans.add(a);
        }
        return ans;
    }
}