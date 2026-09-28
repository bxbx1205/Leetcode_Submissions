class Solution {
    public int prims(ArrayList<ArrayList<int[]>> adj,int V){
        int TC=0;
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            int cost = current[0];
            int node = current[1];

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            TC += cost;

            for(int[] next : adj.get(node)){

                int nextNode = next[0];
                int edgeCost = next[1];

                if(!visited[nextNode]){
                    pq.offer(new int[]{edgeCost,nextNode});
                }
            }
        }
        return TC;
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){

                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new int[]{j,dist});
                adj.get(j).add(new int[]{i,dist});
            }
        }

        return prims(adj,V);
    }
}