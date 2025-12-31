class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Adjec list
        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edg[]:times)
        {
            int u=edg[0];
            int v=edg[1];
            int wt=edg[2];
            adj.get(u).add(new int[]{v,wt});
            //adj.get(v).add(new int[]{u,wt});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dis= new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty())
        {
            int[] val=pq.poll();
            int u_n=val[0];
            int v_d=val[1];
            for(int[] edg:adj.get(u_n))
            {
                int u_node=edg[0];
                int v_dis=edg[1];
                int dis_min=v_d+v_dis;
                if(dis_min<dis[u_node])
                {
                    pq.add(new int[]{u_node,dis_min});
                    dis[u_node]=dis_min;
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            if(dis[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            max=Math.max(max,dis[i]);
        }

        return max;
        

    }
}