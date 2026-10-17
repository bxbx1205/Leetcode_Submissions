class Solution {
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            n /= 10;
            sum += last;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            int ds = digitSum(nums[i]);
            arr[i] = new int[] { nums[i], ds, i };
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int currentNum = arr[i][0];

            int neededIndex = map.get(currentNum);

            if (neededIndex == i)
                continue;

            int dusraWala = nums[i];

            nums[i] = nums[i] ^ nums[neededIndex];
            nums[neededIndex] = nums[i] ^ nums[neededIndex];
            nums[i] = nums[i] ^ nums[neededIndex];

            cnt++;

            map.put(currentNum, i);
            map.put(dusraWala, neededIndex);
        }
        return cnt;
    }
}