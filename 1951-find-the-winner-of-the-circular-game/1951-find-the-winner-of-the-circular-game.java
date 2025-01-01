class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> hm=new ArrayList<>();

        for(int i=1;i<=n;i++){
            hm.add(i);
        }

        int curr_ind=0;
        while(hm.size()>1){
            int next_remove=(curr_ind+k-1)%hm.size();
            hm.remove(next_remove);
            curr_ind=next_remove;
        }
        return hm.get(0);
    }
}