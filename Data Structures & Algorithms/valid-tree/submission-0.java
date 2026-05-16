class Solution {
    boolean ans = true;
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i= 0; i < n; i++)
        {
            adj.add(i, new ArrayList<>());
        }
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(vis, adj, -1, 0);
        for(boolean e: vis)
        {
            ans = ans & e;
        }
        return ans;
    }
    public void dfs(boolean[] vis, List<List<Integer>> adj, int parent, int node)
    {
        vis[node] = true;
        for(int neighbour: adj.get(node))
        {
            if(neighbour != parent && vis[neighbour] == true)
            {
                ans = false;
                //return;
            }
            if(vis[neighbour] == false)
                dfs(vis, adj, node, neighbour);
        }

    }
}
