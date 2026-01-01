class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V=edges.length+1;
        for(int i=0;i<=V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edg:edges)
        {
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //int k=0;
      for (int i = 1; i < adj.size(); i++) {
            if (adj.get(i).size() == edges.length) {
                return i;
            }
        }
        return -1;
    }
}