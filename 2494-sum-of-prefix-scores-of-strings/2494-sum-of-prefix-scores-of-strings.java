class TrieNode{
    TrieNode children[] = new TrieNode[26];
    int nodeFreq = 0;
    void insert(String key){
        TrieNode curr = this;
        for(var chr : key.toCharArray()){
            int indx = (int) (chr - 'a');
            if(curr.children[indx] == null){
                curr.children[indx] = new TrieNode();
            }
            curr.children[indx].nodeFreq++;
            curr = curr.children[indx];
        }
    }
    int findScore(String key){
        TrieNode curr = this;
        int score =  0;
        for(var chr : key.toCharArray()){
            int indx = (int) (chr - 'a');
            score += curr.children[indx].nodeFreq;
            curr = curr.children[indx];
        }
        return score;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for(var word : words){
            root.insert(word);
        }
        int size = words.length;
        int answer[] = new int[size];
        for(int indx = 0; indx < size; indx++){
            answer[indx] = root.findScore(words[indx]);
        }       
        return answer;
    }
}