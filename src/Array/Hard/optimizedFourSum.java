package Array.Hard;

import java.util.*;

public class optimizedFourSum {
    static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr, 0));
    }

    static public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        long T = target;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == T) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < T) {
                        k++;
                    } else{ l--;
                    }
                }
            }
        }
        return ans;
    }
}
