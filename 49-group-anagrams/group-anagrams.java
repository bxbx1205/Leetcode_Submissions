class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // Arrays.sort(strs);
        int n  = strs.length;

        for (int i = 0; i < n; i++) {
            String temp = strs[i];
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            temp = new String(arr);

            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);

        }

        for(ArrayList<String> current : map.values()){
            ans.add(current);
        }

        return ans;
    }
}