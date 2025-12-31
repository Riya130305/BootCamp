// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis= new int[V];
        Arrays.fill(dis,(int)1e8);
        dis[src]=0;
        for(int i=0;i<V;i++)
        {
            for(int[] edg:edges)
            {
                int u=edg[0];
                int v=edg[1];
                int w=edg[2];
                if(dis[u]+w<dis[v] && dis[u]!=(int)1e8)
                {
                    dis[v]=dis[u]+w;
                }
            }
        }
          for(int[] edg:edges)
            {
                int u=edg[0];
                int v=edg[1];
                int w=edg[2];
                if(dis[u]+w<dis[v] && dis[u]!=(int)1e8)
                {
                    return new int[]{-1};
                }
            }
        
        return dis;
    }
}
