class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(0,rooms,visited);

        for(boolean v:visited){
            if(!v){
                return false;
            }
        }
        return true;
    }

    public void dfs(int curr,List<List<Integer>> rooms,boolean[] visited){
        if(visited[curr]) return;
        visited[curr]=true;

        for(int keys:rooms.get(curr)){
            if(!visited[keys]){
                dfs(keys,rooms,visited);
            }
        }
    }
}