import java.util.*;
public class DFS{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
    Arrays.asList(
        new ArrayList<>(Arrays.asList(1, 2)),
        new ArrayList<>(Arrays.asList(0, 2)),
        new ArrayList<>(Arrays.asList(0, 1, 3, 4)),
        new ArrayList<>(Arrays.asList(2)),
        new ArrayList<>(Arrays.asList(2))
    )
);
        dfs(adj);

    }
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        boolean[] visited= new boolean[adj.size()];
        int node=0;
        for(int i=node;i<adj.size();i++)
        {
            if(!visited[i])
            {
                fun(i,adj,visited,ans);
            }
        }
        // System.out.println(ans);
        return ans;
        
    }
    public static void fun(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited,ArrayList<Integer> ans)
    {
        visited[node]=true;
        ans.add(node);
        for(int nbr:adj.get(node))
        {
            if(!visited[nbr])
            {
                //visited[nbr]=true;
                fun(nbr,adj,visited,ans);
            }
        }
}
}