class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        //Adjecny list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
       for(int[] edg: edges)
       {
           int u=edg[0];
           int v=edg[1];
           int w=edg[2];
           
           adj.get(u).add(new int[]{v,w});
           adj.get(v).add(new int[]{u,w});
       }
       
       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
       int[] dis = new int[V];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[src]=0;
       pq.add(new int[]{src,0});
       
       while(!pq.isEmpty())
       {
           int[] val=pq.poll();
           int nodeval=val[0];
           int disval=val[1];
           for(int[] nbr:adj.get(nodeval))
           {
               int nbr_node=nbr[0];
               int nbr_dis=nbr[1];
               int minD=nbr_dis+disval;
               if(minD<dis[nbr_node])
               {
                   dis[nbr_node]=minD;
                   pq.add(new int[]{nbr_node,minD});
               }
           }
       }
       return dis;
        
    }
}