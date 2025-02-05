class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,graph,color,V)==false){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean check(int start,int[][] graph,int[] color,int V){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();

           for(int neighbour:graph[node]){
             if(color[neighbour]==-1){
                color[neighbour]=1-color[node];
                q.add(neighbour);
             }

             if(color[neighbour]==color[node]){
                return false;
             }
           }
        }
        return true;
    }
}