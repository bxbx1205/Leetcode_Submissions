class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt=0;
        Stack<int[]> st = new Stack<>();
        boolean[][] visited = new boolean[n][m];
        // for(int[] arr :visited){
        //     Arrays.fill(arr,false);
        // }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    boolean closed=true;

                    visited[i][j]=true;
                    st.push(new int[]{i,j});

                    while(!st.isEmpty()){
                        int[] curr = st.pop();
                        int currRow = curr[0];
                        int currCol = curr[1];

                        if(currRow==0 || currRow==n-1 || currCol==0 || currCol==m-1){
                            closed = false;
                        }

                        for(int [] dir : dirs){
                            int newRow = currRow+dir[0];
                            int newCol = currCol + dir[1];

                            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol] == 0 && !visited[newRow][newCol]){
                                visited[newRow][newCol]=true;
                                st.push(new int[]{newRow,newCol});
                            }
                        }
                    }

                    if(closed){
                        cnt++;
                    }
                }                
            }
        }

        return cnt;
    }
}