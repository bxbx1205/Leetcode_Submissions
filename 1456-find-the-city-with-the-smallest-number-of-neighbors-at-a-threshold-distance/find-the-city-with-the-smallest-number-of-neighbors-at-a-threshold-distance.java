class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int max = 1000000000;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=max;
            }

            dist[i][i]=0;
        }

        for(int[] e :edges){
            int from = e[0];
            int to = e[1];
            int wt = e[2];

            dist[from][to]=wt;
            dist[to][from]=wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        int ans=-1;

        int minCount=max;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }
}