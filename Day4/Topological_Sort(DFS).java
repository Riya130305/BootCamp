class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,st,ans,adj);
            }
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        return ans;
        
    }
    public void dfs(int node,boolean[] visited,Stack<Integer> st ,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=true;
        for(int nbr:adj.get(node))
        {
            if(!visited[nbr])
            {
                dfs(nbr,visited,st,ans,adj);
            }
        }
        //nbr nhi hai ya sare node visited hoge hai then add to stack
        st.push(node);
    }
}