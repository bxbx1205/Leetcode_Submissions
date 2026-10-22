class Solution {

    public boolean inGood(int[] nums) {

        int cnt = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int next = (i + 1) % n;

            if (nums[next] < nums[i]) {
                cnt++;
            }
        }

        return cnt <= 1;
    }

    public void reverse(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    public int minOperations(int[] nums) {

        int n = nums.length;

        // Original array
        if (inGood(nums)) {

            int minIndex = -1;

            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    minIndex = i;
                    break;
                }
            }

            int ans1 = minIndex;

            int ans2 = (n - minIndex) + 2;

            return Math.min(ans1, ans2);
        }

        reverse(nums);

        if (inGood(nums)) {

            int minIndex = -1;

            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    minIndex = i;
                    break;
                }
            }

            int ans1 = minIndex + 1;
            int ans2 = (n - minIndex) + 1;

            return Math.min(ans1, ans2);
        }

        return -1;
    }
}