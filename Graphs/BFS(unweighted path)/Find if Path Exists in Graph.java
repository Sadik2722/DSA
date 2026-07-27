class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int [] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] vis=new boolean[n];
        return dfs(graph,source,destination,vis);
    }
    public boolean dfs(ArrayList<Integer>[] graph,int curr,int dest,boolean[] vis){
        if(curr==dest)return true;
        
        vis[curr]=true;

        for(int neighbor:graph[curr]){
            if(!vis[neighbor] && dfs(graph,neighbor,dest,vis)){
                return true;
            }
        }
        return false;
    }
}
