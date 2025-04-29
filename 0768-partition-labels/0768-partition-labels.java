class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();

        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),i);
        }

        int start=0;
        int end=0;

        for(int i=0;i<n;i++){
            end=Math.max(end,hm.get(s.charAt(i)));

            if(i==end){
                ans.add(end-start+1);
                start=i+1;
            }
        }
        return ans;

    }
}