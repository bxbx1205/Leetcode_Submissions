class Solution {
    int[] parent;

    public int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x]=find(parent[x]);
    }

    public void union(int a , int b){
        int pa=find(a);
        int pb=find(b);

        if(pa!=pb){
            parent[pb] = pa;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        int cnt=0;

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int[] con : connections){
            union(con[0],con[1]);
        }

        for(int i=0;i<n;i++){
            if(parent[i]==i) cnt++;   
        }
        
        


        return cnt-1;
    }
}