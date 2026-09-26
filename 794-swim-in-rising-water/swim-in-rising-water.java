class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // int time =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,grid[i][j]);
            }
        }

        if(grid[n-1][n-1]==max){
            return max;
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0],0,0});
        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int time = current[0];
            int r = current[1];
            int c = current[2];

            if(visited[r][c]){
                continue;
            }
            visited[r][c] = true;

            if (r == n - 1 && c == n - 1) {
                return time;
            }
            
            for(int[] d : dir){
                int newRow = r + d[0];
                int newCol = c+d[1];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && !visited[newRow][newCol]){
                    int newTime = Math.max(time,grid[newRow][newCol]);
                    pq.offer(new int []{newTime,newRow,newCol});
                }
            }
        }
         
        return -1;
    }
}