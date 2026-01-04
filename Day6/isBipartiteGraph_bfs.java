import java.util.*;
public class isBipartiteGraph_bfs {
    public static void main(String[] args) {
        int[][] graph={{1,2,3},{0,2},{0,1,3},{0,2}}; //== false   // {{1,2},{0,3},{0},{1}};== true
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int V =graph.length;
        int[] color=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) color[i]=-1;
        for (int i = 0; i < V; i++) {
            if (color[i] == -1){
                q.add(i);
                color[i]=0;

            }
            while(!q.isEmpty()){
                int node=q.poll();
                for(int neighbor:graph[node]){
                    if(color[neighbor]==-1){
                        // to opposite color
                        color[neighbor]=1-color[node];
                        q.offer(neighbor);
                    }
                    else if(color[node]==color[neighbor]) return false;
                }
            }
        }
        return true;
    }
}