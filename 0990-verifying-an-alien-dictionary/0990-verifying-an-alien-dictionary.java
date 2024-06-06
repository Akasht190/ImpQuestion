class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<order.length();i++){
            hm.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length();j++){
                //Batman,Bat
                if(j>=words[i+1].length()){
                    return false;
                }

                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    int currentWord=hm.get(words[i].charAt(j));
                    int nextWord=hm.get(words[i+1].charAt(j));

                    if(nextWord<currentWord){
                        return false;
                    }else{
                        break;
                    }
                }
            }
        }
        return true;
    }
}