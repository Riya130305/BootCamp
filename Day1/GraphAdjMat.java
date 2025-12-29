import java.util.*;
public class GraphAdjMat {
    public static void main(String[] args) {
        int n=3;
        int[][] mat = new int[n][n];
       // ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        int[][] edg= {{0,1},{1,2},{0,2}};
        // for(int i=0;i<n;i++)
        // {
        //     arr.add(new ArrayList<>());
        // }
        for(int[] edge:edg){
            int u=edge[0];
            int v=edge[1];
            mat[u][v]=1;
            mat[v][u]=1;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
