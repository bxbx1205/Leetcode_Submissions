class Solution {
    public void helper(List<List<Integer>> ans, int n , int k, ArrayList<Integer> current,int ii){
        if(current.size()==k){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=ii;i<=n;i++){
            current.add(i);
            helper(ans,n,k,current,i+1);
            current.remove(current.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // int[] taken = new int[n+1];
        // Arrays.fill(taken,false);
        helper(ans,n,k,new ArrayList<>(),1);
        return ans;
    }
}