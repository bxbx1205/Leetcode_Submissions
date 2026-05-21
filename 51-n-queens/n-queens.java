class Solution {

    static boolean isSafe(int row,int col,int n,char[][] board){
        int r=row;
        int c=col;

        while(r>=0 && c<n){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }
        r=row;
        c=col;
        while(c>=0 && r>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        while(r>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
        }

        return true;


    }

    static void recurse(int row,char[][] board,int n,List<List<String>> ans){
        if(row==n){
            List<String> temp = new ArrayList<>();

            for(int i=0;i <n;i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }


        for(int col=0;col<n;col++){
            if(isSafe(row,col,n,board)){
                board[row][col]='Q';
                recurse(row+1,board,n,ans);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        recurse(0,board,n,ans);

        return ans;
    }
}