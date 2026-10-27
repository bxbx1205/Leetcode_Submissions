class Solution {
    public String[] createGrid(int m, int n) {
        String [] ans = new String[m];
        for(int i=0;i<m;i++){
            String currRow ="";

            for(int j=0;j<n;j++){
                if(i==0){
                    currRow+='.';
                }
                else if(j==n-1){
                    currRow+='.';
                }
                else{
                    currRow+='#';
                }
                
            }
            ans[i]=currRow;
        }
        return ans;
    }
}