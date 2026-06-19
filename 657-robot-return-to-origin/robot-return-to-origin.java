class Solution {
    public int helper(char s){

        switch (s){
            case 'U':
                return 1;
                // break;
            case 'D':
                return -1;
                // break;
            case 'L':
                return 1;
                // break;
            case 'R':
                return -1;
                // break;
        }

        return 0;
    }
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;

        for(char s : moves.toCharArray()){
            if(s=='L' || s=='R'){
                x=x+helper(s);
            }
            else{
               y=y+helper(s); 
            }
        }

        return x == 0 && y == 0; 

    }
}