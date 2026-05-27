class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int i = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                map.putIfAbsent(ch, i);
            } else {
                map.put(ch, i);
            }
            i++;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map.containsKey(ch) && map.containsKey(Character.toUpperCase(ch))) {
                if (map.get(ch) < map.get(Character.toUpperCase(ch))) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}