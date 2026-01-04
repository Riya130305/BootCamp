import java.util.LinkedList;
import java.util.Queue;

public class isBipartiteGraph_dfs {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};//false
        System.out.println(check(graph));
    }
    public static boolean check(int[][] graph){
        int V =graph.length;
        int[] color=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) color[i]=-1;
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(graph,color,i,0) == false) return false;
            }
        }
        return true;
    }
    public static boolean dfs(int[][] graph,int[] color,int node,int col){
        color[node]=col;
        for(int neighbor:graph[node]){
            if(color[neighbor]==-1){
                if (dfs(graph,color,neighbor,1-col) == false) return false;
            }
            else if(color[node]==color[neighbor]) return false;
        }
        return true;
    }
}