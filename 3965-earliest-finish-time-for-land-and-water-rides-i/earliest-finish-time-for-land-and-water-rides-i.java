class Solution {

    static int helper(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int ans = Integer.MAX_VALUE;
        int lowLand=Integer.MAX_VALUE;
        for(int i = 0 ;i<landStartTime.length;i++){
            lowLand=Math.min(lowLand,landStartTime[i]+landDuration[i]);
        }

        for(int i = 0 ;i<waterStartTime.length;i++){
            int waterStart=Math.max(lowLand,waterStartTime[i]);
            ans=Math.min(ans,waterStart+waterDuration[i]);
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
      int first = helper(landStartTime, landDuration, waterStartTime,  waterDuration);

      int second = helper( waterStartTime,  waterDuration,  landStartTime,  landDuration);

      int ans= Math.min(first,second);

      return ans;
    }
}