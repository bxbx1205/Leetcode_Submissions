class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n =cost.length;
        int costing=0;

        int skipper=2;
        for(int i=n-1;i>=0;i--){
            if(skipper==0){
                skipper=2;
                continue;
            }
            costing=costing+cost[i];
            skipper--;
            
        }

        return costing;
    }
}