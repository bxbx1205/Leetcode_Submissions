class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> l1 = new HashMap<>();
        HashMap<String, Integer> l2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            l1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            l2.put(list2[i], i);
        }

        List<String> ans = new ArrayList<>();

        int minSum = Integer.MAX_VALUE;

        for (String str : l1.keySet()) {

            if (l2.containsKey(str)) {

                int sum = l1.get(str) + l2.get(str);

                if (sum < minSum) {
                    minSum = sum;
                    ans.clear();
                    ans.add(str);
                }
                else if (sum == minSum) {
                    ans.add(str);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}