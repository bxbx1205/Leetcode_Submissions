class Solution {
    public int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x]=find(parent,parent[x]);
    }

    public boolean union(int[] parent , int a ,int b){
        int pa=find(parent,a);
        int pb=find(parent,b);

        if(pa==pb){
            return false;
        }

        parent[pb] = pa;

        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            if (!union(parent, u, v)) {
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }
}