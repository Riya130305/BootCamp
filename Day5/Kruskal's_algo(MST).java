// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
    UnionFind uf=new UnionFind(V);
        int ans =0;
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        
        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
            int wt=edg[2];
            
            if(uf.union(u,v)==true)
            {
                ans+=wt;
            }
            
        }
        return ans;
    }
    
}
class UnionFind{ 
    int[] parent;
    int[] rank;
    UnionFind(int V){
        parent=new int[V+1];
        rank=new int[V+1];

        for(int i=0;i<=V;i++){
            parent[i]=i;      //initially hr node k liye whi uska parent hoga
        }
    }
   //This find function is searching for the leader(root node) of the current node.
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return find(parent[node]);
    }

    int findWithPathCompression(int node){
        if(parent[node]==node){
            return node;
        }
        //path compression
        parent[node]=findWithPathCompression(parent[node]);
        return parent[node];
    }


    boolean union(int u,int v){
        int parent_u=find(u);
        int parent_v=find(v);

        if(parent_u==parent_v){
            return false;
        }

        if(rank[parent_u]>rank[parent_v]){   //rank of u>rank of v
            parent[parent_v]=parent_u;
        }
        else if(rank[parent_v]>rank[parent_u]){  //rank of v>rank of u
            parent[parent_u]=parent_v;
        }
        else{                            //(rank of u==rank of v)
            parent[parent_v]=parent_u;  //agr dono ki rank same hai toh mene u ko v ka parent bna diya
            rank[parent_u]++;          //rank of u will increase.
        }                  
        return true;

    }
}



