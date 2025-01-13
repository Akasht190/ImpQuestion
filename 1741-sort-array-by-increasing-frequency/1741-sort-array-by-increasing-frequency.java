class Pair implements Comparable<Pair>{
    int num;
    int freq;

    Pair(int n,int f){
        this.num=n;
        this.freq=f;
    }

    @Override
    public int compareTo(Pair p2){
        if(this.freq==p2.freq){
            return p2.num-this.num;
        }
        else{
            return this.freq-p2.freq;
        }
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
       HashMap<Integer,Integer> hm=new HashMap<>();
      for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }


       PriorityQueue<Pair> q=new PriorityQueue<>();
       for(int i:hm.keySet()){
          q.add(new Pair(i,hm.get(i)));
       }
        int n=nums.length;
       int i=0;
       int[] ans=new int[n];

       while(i<ans.length && !q.isEmpty()){
            Pair curr=q.remove();
            while(curr.freq!=0){
                ans[i++]=curr.num;
                curr.freq-=1;
            }
       }
       return ans;
    }
}