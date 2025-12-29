import java.util.*;

public class GraphAdjList{
    public static void main(String[] args)
    {
        int v=4;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[][] edg= {{0,1},{0,2},{2,3},{1,2}};

        for(int i=0;i<v;i++)
        {
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++)
        {
            arr.get(edg[i][0]).add(edg[i][1]);
            arr.get(edg[i][1]).add(edg[i][0]);
        }
        System.err.println(arr);


    }

}