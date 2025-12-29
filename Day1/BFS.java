import java.util.*;
public class BFS {
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
        bfs(adj);

    
    }
    public static ArrayList<Integer> bfs( ArrayList<ArrayList<Integer>> adj )
    {
        ArrayList<Integer>arr = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>() ;
        boolean visited[]= new boolean[adj.size()];
        int node=0;
        fun(adj,arr,q,node,visited);
        return arr;
    } 
    public static void fun(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>ans, Queue<Integer> q,int node, boolean visited[])
    {
        visited[node]=true;
        q.add(node);
        while(!q.isEmpty()){
            int poll=q.poll();
            ans.add(poll);
        for(int nbr:adj.get(poll))
        {
            if(!visited[nbr])
            {
                q.add(nbr);
                fun(adj, ans, q, node, visited);
            }
        }
    }

    }
    
}