class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int[] ans = new int[k];

        for(int[] current : logs){
            int id=current[0];
            int time = current[1];

            map.computeIfAbsent(current[0], fn -> new HashSet<>()).add(time);
        }
        
        for(int key :map.keySet()){
            HashSet<Integer> curr = map.get(key);

            int size = curr.size();
            ans[size-1]++;
        }


        return ans;
    }
}