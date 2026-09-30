class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;

        while (index < n) {

            ArrayList<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);

            for (int key : keys) {
                ans[index++] = key;

                int freq = map.get(key);

                if (freq - 1 == 0) {
                    map.remove(key);
                } else {
                    map.put(key, freq - 1);
                }
            }
        }

        return ans;
    }
}