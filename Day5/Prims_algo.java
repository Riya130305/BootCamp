import java.util.*;

public class Prims_algo {
    static int primsMST(int V, int[][] edges) {
        // code here
        
        //Adjacency list
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edg:edges)
        {
            int parent=edg[0];
            int node=edg[1];
            int wt=edg[2];
            
            adj.get(parent).add(new int[]{node,wt});
            adj.get(node).add(new int[]{parent,wt});
        }
        
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int sum=0;
        
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty())
        {
            //step1 poll
            int[] val =pq.poll();
            int parent=val[0];
            int node=val[1];
            int wt=val[2];
            
            if(visited[node])
            {
                continue;
            }
            else
            {
                visited[node]=true;
            }
            sum+=wt;
            for(int[] edg:adj.get(node))
            {
                int node1=edg[0];
                int wt1=edg[1];
                
                if(!visited[node1])
                {
                    pq.add(new int[]{node,node1,wt1});
                }
            }
        }
            return sum;
    }

    public static void main(String[] args) {
        int V =9 ;
        int[][] edges = {
                {0, 1, 4},
                {0, 7, 8},
                {1, 2, 8},
                {1, 7, 11},
                {2, 3, 7},
                {2, 8, 2},
                {2, 5, 4},
                {3, 4, 9},
                {3, 5, 14},
                {4, 5, 10},
                {5, 6, 2},
                {6, 7, 1},
                {6, 8, 6},
                {7, 8, 7}
        };
        //weigth is in end
        int mstSum = primsMST(V, edges);
        System.out.println("Minimum Spanning Tree sum: " + mstSum);
    }
}
