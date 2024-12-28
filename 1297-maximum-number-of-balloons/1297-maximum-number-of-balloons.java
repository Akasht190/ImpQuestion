class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hm=new HashMap<>();

        for(char i:text.toCharArray()){
            if(i=='b' || i=='o' || i=='l' || i=='a' || i=='n'){
                hm.put(i,hm.getOrDefault(i,0)+1);
            }
        }

        int x=Math.min(hm.getOrDefault('b',0),Math.min(hm.getOrDefault('a',0),hm.getOrDefault('n',0)));

        int xx=Math.min(hm.getOrDefault('l',0),hm.getOrDefault('o',0));

        return Math.min(xx/2,x);
    }
}