  class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int V)
        {
            parent=new int[V+1];
            rank=new int[V+1];

            for(int i=0;i<=V;i++)
            {
                parent[i]=i;
            }

        }
        int find(int node)
    {
        if(parent[node]==node)
        {
            return node;
        }
        return find(parent[node]);
    }
    boolean union(int u,int v)
    {
        int parent_u=find(u);
        int parent_v=find(v);

        if(parent_v==parent_u)
        {
            return false;
        }

        if(rank[parent_u]>rank[parent_v])
        {
            parent[parent_v]=parent_u;
        }
        else if(rank[parent_u]<rank[parent_v])
        {
            parent[parent_u]=parent_v;
        }
        else
        {
            parent[parent_v]=parent_u;
            rank[parent_u]++;
        }
        return true;
    }
}
class Solution {
  
   
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf=new UnionFind(n);

        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
            uf.union(u,v);
        }

        int parent_u=uf.find(source);
        int parent_v=uf.find(destination);
        if(parent_v==parent_u)
        {
            return true;
        }
        return false;
    }
}

