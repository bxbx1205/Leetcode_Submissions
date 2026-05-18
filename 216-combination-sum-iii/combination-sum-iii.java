class Solution {
    static void sarvesh(int ii,int k,int n,List<List<Integer>> ans,List<Integer> ds,int sum){
        if(sum==n && ds.size()==k){
            ans.add(new ArrayList(ds));
            return;
        }

        if(sum>n ||ds.size()>k){
            return;
        }
        for(int i=ii;i<=9;i++){
            sum+=i;
            ds.add(i);
            sarvesh(i+1,k,n,ans,ds,sum);
            
            sum-=i;
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        sarvesh(1, k, n,ans,ds,0);

        return ans;        
    }
}