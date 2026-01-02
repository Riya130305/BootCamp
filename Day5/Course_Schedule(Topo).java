import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        int[] inDegree=new int[numCourses];
        
        for(int[] edg:prerequisites)
        {
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int val=q.poll();
            ans.add(val);
            for(int edg:adj.get(val))
            {
                if(inDegree[edg]!=0)
                {
                    inDegree[edg]--;
                }
                if(inDegree[edg]==0)
                {
                   q.add(edg);
                }
            }
        }
        if(ans.size()==numCourses)
        return true;
        return false;

    }
}