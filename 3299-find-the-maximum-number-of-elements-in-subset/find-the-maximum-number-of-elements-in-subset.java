class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 1;

        if (map.containsKey(1)) {
            int ones = map.get(1);

            if (ones % 2 == 0) {
                ones--;
            }
            max = Math.max(ones, max);
        }

        for (int num : map.keySet()) {

            if (num == 1)
                continue;

            int currentLength = 0;
            int current = num;

            while (map.containsKey(current) && map.get(current) >= 2) {
                currentLength += 2;
                current *= current;
            }

            if (map.containsKey(current) && map.get(current) > 0) {
                currentLength += 1;
            } else {
                currentLength -= 1;
            }

            max = Math.max(currentLength, max);

        }
        return max;
    }
}