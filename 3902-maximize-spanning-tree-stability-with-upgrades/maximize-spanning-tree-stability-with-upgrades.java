
class Solution {

    class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return false;
            }

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        int maxStrength = 0;
        int minMandatory = Integer.MAX_VALUE;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            maxStrength = Math.max(maxStrength, s);

            if (m == 1) {

                if (!dsu.union(u, v)) {
                    return -1;
                }

                minMandatory = Math.min(minMandatory, s);
            }
        }

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        if (dsu.components > 1) {
            return -1;
        }

        int left = 1;

        int right = 2 * maxStrength;

        if (minMandatory != Integer.MAX_VALUE) {
            right = Math.min(right, minMandatory);
        }

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(n, edges, k, mid)) {

                ans = mid;

                left = mid + 1;

            } else {

    
                right = mid - 1;
            }
        }

        return ans;
    }
        boolean check(int n, int[][] edges, int k, int mid) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }

                dsu.union(u, v);
            }
        }
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 0 && s >= mid) {
                dsu.union(u, v);
            }
        }

        int upgrades = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];


            if (m == 0 && s < mid && 2 * s >= mid) {

                if (dsu.find(u) != dsu.find(v)) {

                    if (upgrades == k) {
                        return false;
                    }

                    dsu.union(u, v);
                    upgrades++;
                }
            }
        }

        return dsu.components == 1;
    }
}
