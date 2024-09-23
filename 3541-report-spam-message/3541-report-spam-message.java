class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> hm=new HashSet<>();
        int count=0;

        for(String word:bannedWords){
            hm.add(word);
        }

        for(String word:message){
             if(hm.contains(word)){
                count++;

                if(count>=2){
                    return true;
                }
             }
        }
        return false;
    }
}