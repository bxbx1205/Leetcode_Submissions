class Solution {
    public int countOverlaps(int[][] img1, int[][] img2,int row, int col){
        int count=0;
        int n = img1.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                int bI= i + row;
                int bJ= j + col;

                if(bI<0 || bI>=n || bJ<0|| bJ>=n){
                    continue;
                }

                if(img1[i][j]==img2[bI][bJ]){
                    if(img1[i][j]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        if (n == 1) return (img1[0][0] == img2[0][0] && img1[0][0]==1) ? 1 : 0;



        int max =0;

        for(int row =-n+1;row<n;row++){
            for(int col =-n+1;col<n;col++){
                int current = countOverlaps(img1,img2,row,col);
                max=Math.max(max,current);
            }
        }

        return max;
    }
}