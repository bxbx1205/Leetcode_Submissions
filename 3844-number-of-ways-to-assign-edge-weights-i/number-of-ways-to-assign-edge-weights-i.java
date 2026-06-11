class Solution {

    static final int MOD = 1000000007;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int maxDepth = findDepth(1, 0, graph);

        long ans = 1;

        for (int i = 1; i < maxDepth - 1; i++) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }

    int findDepth(int node, int parent, ArrayList<Integer>[] graph) {

        int depth = 1;

        for (int next : graph[node]) {

            if (next == parent) {
                continue;
            }

            depth = Math.max(
                    depth,
                    1 + findDepth(next, node, graph));
        }

        return depth;
    }
}