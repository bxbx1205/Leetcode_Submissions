class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        int i=0;
        int j=m-1;
        // HashSet<Character> set = new HashSet<>();
        int[] arr = new int[26];
        for(char ch : p.toCharArray()){
            arr[ch-'a']++;
        }

        List<Integer> ans = new ArrayList<>();

        while(j<n){
            int[] map = new int[26];

            for(int k=i;k<=j;k++){
                map[s.charAt(k)-'a']++;
            }

            if(Arrays.equals(arr,map)){
                ans.add(i);
            }

            i++;
            j++;
        }

        return ans;
    }
}