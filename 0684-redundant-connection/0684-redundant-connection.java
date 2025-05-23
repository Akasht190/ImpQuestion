class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
         parent=new int[n+1];

         for(int i=1;i<n;i++){
            parent[i]=i;
         }

         for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(find(u)==find(v)) return edge;
            union(u,v);
         }
         return new int[0];
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void union(int u,int v){
        parent[find(u)]=find(v);
    }
}