class Solution {
    public int helper(String s,int goal){
        int total=0;
        int right=0;
        int left=0;
        int n =s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        while(right<n){
            char current=s.charAt(right);
            map.put(current,map.getOrDefault(current,0)+1);

            while(map.size()>goal){
                char currentLeft=s.charAt(left);

                map.put(currentLeft,map.getOrDefault(currentLeft,1)-1);

                if(map.get(currentLeft)<=0){
                    map.remove(currentLeft);
                }
                left++;
            }

            total+=right-left+1;
            right++;
        }

        return total;
    }
    public int numberOfSubstrings(String s) {
        return helper(s,3)-helper(s,2);
    }
}