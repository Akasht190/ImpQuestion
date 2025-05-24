class Solution {
     class DSU{
        int n;
        int parent[];
        int size[];
        public DSU(int n){
            this.n=n;
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            size=new int[n];
            Arrays.fill(size,1);
        }
        public int find_parent(int x){
            if(parent[x]==x)return x;
            return parent[x]=find_parent(parent[x]);
        }
        public void union(int u,int v){
            int u_parent=find_parent(u);
            int v_parent=find_parent(v);
            if(u_parent!=v_parent){
                if(size[u_parent]>=size[v_parent]){
                    parent[v_parent]=u_parent;
                    size[u_parent]+=size[v_parent];
                }else{
                     parent[u_parent]=v_parent;
                    size[v_parent]+=size[u_parent];
                }
            }
        }
    }
    public  int[] cycle(int edges[][],int extraedge){
        int n=edges.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            if(i==extraedge)continue;
            int e[]=edges[i];
            int u=e[0]-1;
            int v=e[1]-1;
            
            if(dsu.find_parent(u)!=dsu.find_parent(v)){
                dsu.union(u,v);
            }else{
                return new int[]{u+1,v+1};
            }
        }
        return new int[]{-1,-1};
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        int indegree[]=new int[n];
        Arrays.fill(indegree,-1);
        int edge1=-1;
        int edge2=-1;
        for(int i=0;i<n;i++){
            int u=edges[i][0]-1;
            int v=edges[i][1]-1;
            if(indegree[v]==-1){
                indegree[v]=i;
            }else{
                edge1=indegree[v];
                edge2=i;
                break;
            }
        }
        if(edge1==-1 && edge2==-1){// means cycle is confirmed is present
            return cycle(edges,-1);
        }
        // now there are two edges which can be the ans -->the correct ans is the edge which in the cycle part;

       int ans[]=cycle(edges,edge2);
       if(ans[0]==-1 && ans[1]==-1){
        return new int[]{edges[edge2][0],edges[edge2][1]};
       }
       return new int[]{edges[edge1][0],edges[edge1][1]};
    }
}