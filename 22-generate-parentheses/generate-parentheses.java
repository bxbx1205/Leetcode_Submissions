class Solution {

    static void generate(String string,int open,int close,int n ,List<String> ans){
        if(string.length()==n*2){
            ans.add(string);
            return;
        }

        if(open<n){
            generate(string+"(",open+1,close,n ,ans);
        }
        if(close<open){
            generate(string+")",open,close+1,n ,ans);
        }

    }



    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);

        return ans;
    }
}