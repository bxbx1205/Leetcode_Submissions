class Solution {
    
    static boolean recurse(char[][] board, String word,int r,int c,int index){
        if(index==word.length()){
            return true;
        }

        int row=board.length;
        int col=board[0].length;
        if(r<0 || c<0 || r>=row || c>=col){
            return false;
        }

        if(board[r][c] != word.charAt(index)){
            return false;
        }

        if(board[r][c] == '$'){
            return false;
        }

        char ch = board[r][c];
        board[r][c]='$';

        if(recurse(board, word,r-1,c,index+1)||
           recurse(board, word,r+1,c,index+1)||
           recurse(board, word,r,c+1,index+1)||
           recurse(board, word,r,c-1,index+1))
           {
                return true;
           }

           board[r][c]=ch;
           return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(board[r][c]==word.charAt(0)){
                    if (recurse(board,word, r, c,0)) return true;
                }
            }
        }
         return false;
    }
}