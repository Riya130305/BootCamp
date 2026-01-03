// User function Template for Java
import java.util.*;

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
        int mstSum = kruskalsMST(V, edges);
        System.out.println("Minimum Spanning Tree sum: " + mstSum);
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



