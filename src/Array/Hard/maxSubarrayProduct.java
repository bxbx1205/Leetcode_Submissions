package Array.Hard;

public class maxSubarrayProduct {
    static void main(String[] args) {
        int[] arr={-2,0,-1};
        System.out.println(maxProduct(arr));
    }
    static public int maxProduct(int[] nums) {

        int pre=1;
        int suf=1;
        int ans= Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre*=nums[i];
            suf*=nums[nums.length-i-1];

            ans=Math.max(ans,Math.max(pre,suf));

        }
        return ans;
    }
}
