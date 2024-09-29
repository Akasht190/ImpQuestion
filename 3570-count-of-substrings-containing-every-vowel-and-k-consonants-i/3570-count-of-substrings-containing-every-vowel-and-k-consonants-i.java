class Solution {
    public int countOfSubstrings(String word, int k) {
        int n=word.length();
        int totalCount=0;
        HashSet<Character> hm=new HashSet<>();
        hm.add('a');
        hm.add('e');
        hm.add('i');
        hm.add('o');
        hm.add('u');

        for(int i=0;i<n;i++){
            HashSet<Character> hm1=new HashSet<>();
            int conCount=0;

            for(int j=i;j<n;j++){
                char ch=word.charAt(j);

                if(hm.contains(ch)){
                    hm1.add(ch);
                }
                else if(Character.isLetter(ch)){
                     conCount++;
                }


                if(hm1.size()==5 && conCount==k){
                    totalCount++;
                }
                
                if(conCount>k){
                    break;
                }
            }
        }
        return totalCount;
    }
}