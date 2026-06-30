class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int total=0;
        int n=s.length();

        for(int right=0;right<n;right++){
            char current = s.charAt(right);   
            map.put(current,right);

            if(map.size()>=3){
                total+=Math.min(map.get('a'),Math.min(map.get('b'),map.get('c')))+1;
            }

        }

        return total;
    }
}