import java.util.*;
public class Topological_sort(BFS) {
    public static void main(){

    }
    class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegree=new int[V];
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edg:edges)
        {
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        //Adding 0 first indegree element to queue
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int val=q.poll();
            ans.add(val);
            for(int edg:adj.get(val))
            {
                //decrece the indegree 
                if(inDegree[edg]!=0)
                {
                    inDegree[edg]--;
                }
                //if indegree 0 add again
                if(inDegree[edg]==0)
                {
                   q.add(edg);
                }
            }
        }
        return ans ;
    }
}

}
