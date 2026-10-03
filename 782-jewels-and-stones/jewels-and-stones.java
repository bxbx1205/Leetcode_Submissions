class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }

        int cnt=0;

        for(int i=0;i<stones.length();i++){
            char current = stones.charAt(i);

            if(set.contains(current)) cnt++;
        }

        return cnt;
    }
}