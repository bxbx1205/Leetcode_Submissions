class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                while (left < map.get(ch)) {
                    char leftChar = s.charAt(left);
                    map.remove(leftChar);
                    left++;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            map.put(ch, right);
        }

        return max;
    }
}