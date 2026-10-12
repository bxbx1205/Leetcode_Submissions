class Solution {
    int[] parent;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA != pB) {
            parent[pB] = pA;
        }

        return;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] pawn : allowedSwaps) {
            union(pawn[0], pawn[1]);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int group = find(i);

            map.putIfAbsent(group, new HashMap<>());

            HashMap<Integer, Integer> freq = map.get(group);

            freq.put(source[i],freq.getOrDefault(source[i], 0) + 1);
        }
        
        int dist=0;

        for(int i=0;i<n;i++){
            int group = find(i);

            HashMap<Integer,Integer> freq = map.get(group);
            int cnt=freq.getOrDefault(target[i],0);

            if(cnt>0){
                freq.put(target[i],cnt-1);
            }
            else{
                dist++;
            }


        }

        return dist;
    }
}