
class Pair{
    int key;
    int value;

    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        PriorityQueue<Pair> q=new PriorityQueue<>(

            new Comparator <Pair>(){
                public int compare(Pair a,Pair b){
                    if((b.key-a.key)==0){
                       return b.value-a.value;
                    }
                    else{
                        return b.key-a.key;
                  }
                }
            }
        );

        for(int i:arr){
            q.add(new Pair(Math.abs(i-x),i));

            if(q.size()>k){
                q.poll();
            }
        }

        while(q.size()!=0){
            Pair p=q.poll();
            ans.add(p.value);
        }

        Collections.sort(ans);
        return ans;

    }
}