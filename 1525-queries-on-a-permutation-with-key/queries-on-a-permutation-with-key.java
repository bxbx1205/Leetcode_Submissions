class Solution {
    public int find(LinkedList<Integer> list, int current) {
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if(value==current) return i;
        }

        return -1;
    }

    public void moveFront(LinkedList<Integer> list, int currentIndex) {
    int value = list.remove(currentIndex);
    list.addFirst(value);
    }

    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ans = new int[n];
        int index = 0;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int current = queries[i];

            int currentIndex = find(list, current);
            ans[index++] = currentIndex;
            moveFront(list,currentIndex);
        }

        return ans;
    }
}