class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n=scores.length;
        PriorityQueue<Integer>[] arr=new PriorityQueue[n];
        for(int i=0;i<n;i++){
            arr[i]=new PriorityQueue<>((a,b)->scores[a]-scores[b]);
        }

        for(var e:edges){
            arr[e[0]].offer(e[1]);
            arr[e[1]].offer(e[0]);
            if(arr[e[0]].size()>3) arr[e[0]].poll();
            if(arr[e[1]].size()>3) arr[e[1]].poll();
        }

        int max=-1;
        for(var e:edges){
            for(int i:arr[e[0]]){
                for(int j:arr[e[1]]){
                    if(i!=j && i!=e[1] && j!=e[0]){
                        max=Math.max(max,scores[i]+scores[j]+scores[e[0]]+scores[e[1]]);
                    }
                }
            }
        }
        return max;
    }
}